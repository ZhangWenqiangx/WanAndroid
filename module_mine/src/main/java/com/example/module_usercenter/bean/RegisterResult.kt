package com.example.module_usercenter.bean

class RegisterResult

data class UserInfoResult(
    var coinInfo: CoinInfo,
    var userInfo: UserInfo
)

data class CoinInfo(
    var coinCount: Int, // 可用
    var level: Int, // 可用
    var nickname: String,
    var rank: String, // 可用
    var userId: Int, // 可用
    var username: String
)

data class UserInfo(
    var coinCount: Int,
    var email: String,
    var id: Int,
    var nickname: String,
    var username: String
)