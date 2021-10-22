package com.example.gradle_plugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter
import org.objectweb.asm.tree.AbstractInsnNode

/**
 * author : zhang.wenqiang
 * date : 2021/10/13
 * description :
 */
class TraceMethodVisitor(
    api: Int, mv: MethodVisitor?, access: Int,
    name: String?, desc: String?, className: String?,
    private val traceConfig: Config
) : AdviceAdapter(api, mv, access, name, desc) {

    private var methodName: String? = null
    private var name2: String? = null
    private var className: String? = null
    private val maxSectionNameLength = 127

    init {
        val traceMethod = TraceMethod.create(0, access, className, name, desc)
        this.methodName = traceMethod.getMethodNameText()
        this.className = className
        this.name2 = name
    }

    override fun onMethodEnter() {
        super.onMethodEnter()
        val methodName = generatorMethodName()
        mv.visitLdcInsn(methodName)
        mv.visitMethodInsn(
            INVOKESTATIC,
            traceConfig.mBeatClass,
            "start",
            "(Ljava/lang/String;)V",
            false
        )
        if (traceConfig.mIsNeedLogTraceInfo) {
            println("MethodTrace-trace-method: ${methodName ?: "unknown"}")
        }
    }

    override fun onMethodExit(opcode: Int) {
        mv.visitLdcInsn(generatorMethodName())
        mv.visitMethodInsn(
            INVOKESTATIC,
            traceConfig.mBeatClass,
            "end",
            "(Ljava/lang/String;)V",
            false
        )
    }

    private fun generatorMethodName(): String? {
        var sectionName = methodName
        var length = sectionName?.length ?: 0
        if (length > maxSectionNameLength && !sectionName.isNullOrBlank()) {
            val parmIndex = sectionName.indexOf('(')
            sectionName = sectionName.substring(0, parmIndex)
            length = sectionName.length
            if (length > 127) {
                sectionName = sectionName.substring(length - maxSectionNameLength)
            }
        }
        return sectionName
    }
}