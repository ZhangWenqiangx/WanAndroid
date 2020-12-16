package com.example.module_video.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author : zhang.wenqiang
 * @date : 2020/12/16
 * description :
 */
public class OpenRecBean implements MultiItemEntity {

    @Override
    public String toString() {
        return "OpenRecBean{" +
                "type='" + type + '\'' +
                ", data=" + data +
                ", trackingData=" + trackingData +
                ", tag=" + tag +
                ", id=" + id +
                ", adIndex=" + adIndex +
                '}';
    }

    public static int SQUARE_CARD_COLLECTION = 1;//竖
    public static int AUTO_PLAY_VIDEO_AD = 2;   //视频
    public static int TEXT_CARD = 3;            //横
    public static int FOLLOW_CARD = 4;          //竖
    public static int VIDEO_SMALL_CARD = 5;     //视频播放
    public static int BANNER = 6;               //大图

    /**
     * type : squareCardCollection
     * data : {"dataType":"ItemCollection","header":{"id":5,"title":"开眼编辑精选","font":"bigBold","subTitle":"WEDNESDAY, DECEMBER 16","subTitleFont":"lobster","textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://feed?tabIndex=2","labelList":null,"rightText":"查看往期"},"itemList":[{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/2165/?title=%E5%BC%80%E7%9C%BC%E7%94%9F%E6%B4%BB%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","iconType":"round","description":null,"time":1608080400000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","description":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","library":"DAILY","tags":[{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null,"desc":"告诉他们为什么与众不同","bgPicture":"http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1234,"name":"时代周刊","actionUrl":"eyepetizer://tag/1234/?title=%E6%97%B6%E4%BB%A3%E5%91%A8%E5%88%8A","adTrack":null,"desc":"使\u201c忙人\u201d能够充分了解世界大事","bgPicture":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null,"desc":"匠心、健康、生活感悟","bgPicture":"http://img.kaiyanapp.com/95ba262a92ac99db76794ca56233d5d1.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/314a1e399de4c5708058e7f391619647.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1378,"name":"热爱生活的一万个理由","actionUrl":"eyepetizer://tag/1378/?title=%E7%83%AD%E7%88%B1%E7%94%9F%E6%B4%BB%E7%9A%84%E4%B8%80%E4%B8%87%E4%B8%AA%E7%90%86%E7%94%B1","adTrack":null,"desc":"值得爱的，有那么多","bgPicture":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":5}],"consumption":{"collectionCount":667,"shareCount":308,"replyCount":11,"realCollectionCount":242},"resourceType":"video","slogan":null,"provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"生活","author":{"id":2165,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","name":"开眼生活精选","description":"匠心、健康、生活感悟","link":"","latestReleaseTime":1604365206000,"videoNum":147,"adTrack":null,"follow":{"itemType":"author","itemId":2165,"followed":false},"shield":{"itemType":"author","itemId":2165,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/7c1683c778d58644cced74865284678f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":142,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=226195","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226195&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1608080400000,"playInfo":[{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":21587662},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":21587662}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/56fc3a74ea3724b5f389b634c0d0035a.mp4","fileSizeStr":"4.63MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":227322,"title":"首位获得金狮奖的中国女导演：「无依之地」","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/3145/?title=%E5%BD%B1%E8%A7%86%E6%9D%82%E5%9D%9B&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/5f0f992e79639d621aec91fe760a4836.jpeg?imageMogr2/quality/60/format/jpg","iconType":"round","description":"","time":1608080400000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":227322,"title":"首位获得金狮奖的中国女导演：「无依之地」","description":"「无依之地」（Nomadland）发布正式预告。赵婷凭借导演作品「无依之地」拿下威尼斯金狮奖，她也是史上第一位收获欧洲三大电影节的华人女导演，同时也是继张艺谋、贾樟柯之后，第三位内地金狮奖获得者。本片改编自同名小说，在经济大衰退中甚至失去了工作、失去了的 Fern 的流浪生活。本片由奥斯卡最佳女主角获得者弗兰西斯·麦克多蒙德主演，预计于 2021 年 2 月在北美上映。From SearchlightPictures","library":"DAILY","tags":[{"id":796,"name":"迷影放映室","actionUrl":"eyepetizer://tag/796/?title=%E8%BF%B7%E5%BD%B1%E6%94%BE%E6%98%A0%E5%AE%A4","adTrack":null,"desc":"电影、剧集、戏剧抢先看","bgPicture":"http://img.kaiyanapp.com/64f2b2ed039bd92c3be10d003d6041bf.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/56a8818adb038c59ab04ffc781db2f50.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":220,"name":"改编","actionUrl":"eyepetizer://tag/220/?title=%E6%94%B9%E7%BC%96","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/521d368604ee32280ae45b0fee729101.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bb85141514473b4f992923930b054d9a.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1398,"name":"文学改编电影","actionUrl":"eyepetizer://tag/1398/?title=%E6%96%87%E5%AD%A6%E6%94%B9%E7%BC%96%E7%94%B5%E5%BD%B1","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/d9ae20a50314f87d09c4737a7bc0ee0d.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/d9ae20a50314f87d09c4737a7bc0ee0d.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1025,"name":"影视","actionUrl":"eyepetizer://tag/1025/?title=%E5%BD%B1%E8%A7%86","adTrack":null,"desc":"电影、剧集、戏剧抢先看","bgPicture":"http://img.kaiyanapp.com/8a298964e7c9fc2ae16342832e36d88d.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/9d7fe42c1445031e4c8f2421b652a011.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":793,"name":"影视预告","actionUrl":"eyepetizer://tag/793/?title=%E5%BD%B1%E8%A7%86%E9%A2%84%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/66a25db995c30f130c433b2422111541.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/528bbba3db1e6388c4a97edce734a743.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1401,"name":"威尼斯电影节","actionUrl":"eyepetizer://tag/1401/?title=%E5%A8%81%E5%B0%BC%E6%96%AF%E7%94%B5%E5%BD%B1%E8%8A%82","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":265,"shareCount":175,"replyCount":6,"realCollectionCount":113},"resourceType":"video","slogan":"","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"影视","author":{"id":3145,"icon":"http://img.kaiyanapp.com/5f0f992e79639d621aec91fe760a4836.jpeg?imageMogr2/quality/60/format/jpg","name":"影视杂坛","description":"一个影视相关内容的大杂谈！","link":"","latestReleaseTime":1606924868000,"videoNum":700,"adTrack":null,"follow":{"itemType":"author","itemId":3145,"followed":false},"shield":{"itemType":"author","itemId":3145,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/42769d448409e8a276524a997e823b16.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=227322&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":"","duration":125,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=227322","forWeibo":"http://www.eyepetizer.net/detail.html?vid=227322"},"releaseTime":1608080400000,"playInfo":[],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":"","descriptionPgc":"","remark":"","ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/bc8ff3c9c529798ec32bf877ebb80d8b.mp4","fileSizeStr":"3.44MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"「无依之地」（Nomadland）发布正式预告。赵婷凭借导演作品「无依之地」拿下威尼斯金狮奖，她也是史上第一位收获欧洲三大电影节的华人女导演，同时也是继张艺谋、贾樟柯之后，第三位内地金狮奖获得者。本片改编自同名小说，在经济大衰退中甚至失去了工作、失去了的 Fern 的流浪生活。本片由奥斯卡最佳女主角获得者弗兰西斯·麦克多蒙德主演，预计于 2021 年 2 月在北美上映。From SearchlightPictures","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":54589,"title":"在极光下冲浪，在严寒中燃烧生命","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/447/?title=%E6%AC%A7%E6%B4%B2%E6%97%85%E8%A1%8C%E7%B2%BE%E9%80%89%E8%A7%86%E9%A2%91&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/85360a00de6f3c4dbdf46e65beec8b35.png?imageMogr2/quality/60/format/jpg","iconType":"round","description":null,"time":1506765519000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":54589,"title":"在极光下冲浪，在严寒中燃烧生命","description":"视频拍摄于罗弗敦群岛，这是位于挪威北部的一个神奇岛屿，位于北极圈内，它拥有世上最大的深水珊瑚礁，以及数以百万记的海鸟，更因其远离喧嚣闻名于世。视频里冲浪的人们，真正的厉害，因为罗弗敦群岛是全球位置最北的冲浪地，可想而知的严寒。From Vincent Urban","library":"DAILY","tags":[{"id":10,"name":"跟着开眼看世界","actionUrl":"eyepetizer://tag/10/?title=%E8%B7%9F%E7%9D%80%E5%BC%80%E7%9C%BC%E7%9C%8B%E4%B8%96%E7%95%8C","adTrack":null,"desc":"去你想去的地方，发现世界的美","bgPicture":"http://img.kaiyanapp.com/7ea328a893aa1f092b9328a53494a267.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":14},{"id":1091,"name":"趁盛夏去放假","actionUrl":"eyepetizer://tag/1091/?title=%E8%B6%81%E7%9B%9B%E5%A4%8F%E5%8E%BB%E6%94%BE%E5%81%87","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/f280043e9df9cf4d6da416d2714e7a08.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f280043e9df9cf4d6da416d2714e7a08.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1019,"name":"旅行","actionUrl":"eyepetizer://tag/1019/?title=%E6%97%85%E8%A1%8C","adTrack":null,"desc":"世界这么大，总有你的目的地","bgPicture":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":370,"name":"欧洲","actionUrl":"eyepetizer://tag/370/?title=%E6%AC%A7%E6%B4%B2","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/e5f917d0a272dd19672e7c67e44084d2.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e5f917d0a272dd19672e7c67e44084d2.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":52,"name":"风光大片","actionUrl":"eyepetizer://tag/52/?title=%E9%A3%8E%E5%85%89%E5%A4%A7%E7%89%87","adTrack":null,"desc":"","bgPicture":"http://img.kaiyanapp.com/e484dd6aa22ea3c2e604812b44f8c60c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f333f225c9ccc78819120f3a888b2e7e.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":728,"shareCount":468,"replyCount":10,"realCollectionCount":64},"resourceType":"video","slogan":null,"provider":{"name":"定制来源","alias":"CustomSrc","icon":""},"category":"旅行","author":{"id":447,"icon":"http://img.kaiyanapp.com/85360a00de6f3c4dbdf46e65beec8b35.png?imageMogr2/quality/60/format/jpg","name":"欧洲旅行精选视频","description":"透过影像漫游欧洲","link":"","latestReleaseTime":1574524819000,"videoNum":0,"adTrack":null,"follow":{"itemType":"author","itemId":447,"followed":false},"shield":{"itemType":"author","itemId":447,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/660597ff0fc40da9f67156558d099a28.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/660597ff0fc40da9f67156558d099a28.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/0a61ca686fc575aba436a921c1a007e4.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":151,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=54589","forWeibo":"http://wandou.im/3oe3oq"},"releaseTime":1506765519000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=","size":12824081},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss&udid=","size":12824081}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid="},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":23080263},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":23080263}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":"","descriptionPgc":"","remark":"即使身处严寒，生命依旧燃烧","ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/c886979b464e42c0ca71b4543a09de7b.mp4","fileSizeStr":"3.54MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"视频拍摄于罗弗敦群岛，这是位于挪威北部的一个神奇岛屿，位于北极圈内，它拥有世上最大的深水珊瑚礁，以及数以百万记的海鸟，更因其远离喧嚣闻名于世。视频里冲浪的人们，真正的厉害，因为罗弗敦群岛是全球位置最北的冲浪地，可想而知的严寒。From Vincent Urban","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":225984,"title":"创意爽片｜原来设计灵感都源于生活","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/2161/?title=%E5%BC%80%E7%9C%BC%E5%88%9B%E6%84%8F%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/f4a9aba1c6857ee0cefcdc5aee0a1fc9.png?imageMogr2/quality/60/format/jpg","iconType":"round","description":null,"time":1608080400000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":225984,"title":"创意爽片｜原来设计灵感都源于生活","description":"这则动画将生活中的元素移动变换，迸发创意灵感。小球在管道中穿梭，牙齿在模拟牙床上浮动。基础图形穿插重叠，形成新的 Logo 设计。气球虽然爆炸，但却散落出明亮的碎片。将视角放大，在生活中寻找创意。换个角度看世界，就能获得全新的灵感。From TIMEON","library":"DAILY","tags":[{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":56,"name":"3D","actionUrl":"eyepetizer://tag/56/?title=3D","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/8648e4ce51da8444039ef046194fd6c8.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/8648e4ce51da8444039ef046194fd6c8.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":490,"name":"脑洞","actionUrl":"eyepetizer://tag/490/?title=%E8%84%91%E6%B4%9E","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/c8ac7bb1fa9276ce647d4687d93dea34.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/c8ac7bb1fa9276ce647d4687d93dea34.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":684,"name":"设计","actionUrl":"eyepetizer://tag/684/?title=%E8%AE%BE%E8%AE%A1","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1023,"name":"动画","actionUrl":"eyepetizer://tag/1023/?title=%E5%8A%A8%E7%94%BB","adTrack":null,"desc":"有趣的人永远不缺童心","bgPicture":"http://img.kaiyanapp.com/349cbd33cdf71fc74d5e9c7a00b444fd.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/208aa67386c045497389f015ae28dd29.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":181,"shareCount":112,"replyCount":6,"realCollectionCount":80},"resourceType":"video","slogan":null,"provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"创意","author":{"id":2161,"icon":"http://img.kaiyanapp.com/f4a9aba1c6857ee0cefcdc5aee0a1fc9.png?imageMogr2/quality/60/format/jpg","name":"开眼创意精选","description":"技术与审美结合，探索视觉的无限可能","link":"","latestReleaseTime":1606957209000,"videoNum":0,"adTrack":null,"follow":{"itemType":"author","itemId":2161,"followed":false},"shield":{"itemType":"author","itemId":2161,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/a4ac0a7cf120ab2249880fa7b7cf1e9b.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/a4ac0a7cf120ab2249880fa7b7cf1e9b.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/87011075c669d3d9fc76bc8f6cae404e.png?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/a4ac0a7cf120ab2249880fa7b7cf1e9b.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=225984&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":66,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=225984","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=225984&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1608080400000,"playInfo":[],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/5aa9ce0ef718dd533fadd72ad0599c9b.mp4","fileSizeStr":"3.09MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"这则动画将生活中的元素移动变换，迸发创意灵感。小球在管道中穿梭，牙齿在模拟牙床上浮动。基础图形穿插重叠，形成新的 Logo 设计。气球虽然爆炸，但却散落出明亮的碎片。将视角放大，在生活中寻找创意。换个角度看世界，就能获得全新的灵感。From TIMEON","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":226093,"title":"凯特·布兰切特：用 100 种方式说我爱你","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/168/?title=NOWNESS%E7%8E%B0%E5%9C%A8&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/31588812d55435318fef0983e09a19a2.jpeg?imageMogr2/quality/60","iconType":"round","description":null,"time":1607671339000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":226093,"title":"凯特·布兰切特：用 100 种方式说我爱你","description":"受古希腊哲学家盖伦「Galen」的启发，视频装置艺术家 Marco Brambilla 在他的最新短片「四种气质」中探讨了人类的处境，由奥斯卡金像奖得主凯特·布兰切特主演。Brambilla 用颜色代表四种气质，凯特·布兰切特用多种情绪演绎「我爱你」这句话。该项目是「UnrealCity」活动的一部分，它是伦敦最大的增强现实展览。","library":"DAILY","tags":[{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":94,"name":"实验性","actionUrl":"eyepetizer://tag/94/?title=%E5%AE%9E%E9%AA%8C%E6%80%A7","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/e1a1a2b35f6916636594fe6bff4c5050.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/4aae1da4cea59eb15007e8d306c6eaea.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":976,"shareCount":272,"replyCount":8,"realCollectionCount":418},"resourceType":"video","slogan":null,"provider":{"name":"PGC","alias":"PGC","icon":""},"category":"创意","author":{"id":168,"icon":"http://img.kaiyanapp.com/31588812d55435318fef0983e09a19a2.jpeg?imageMogr2/quality/60","name":"NOWNESS现在","description":"全球创意生活短片平台","link":"","latestReleaseTime":1608024806000,"videoNum":166,"adTrack":null,"follow":{"itemType":"author","itemId":168,"followed":false},"shield":{"itemType":"author","itemId":168,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/3da4dbe8d4145b750f32b4389be92b5a.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/3da4dbe8d4145b750f32b4389be92b5a.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/cad113345336fb9c9b73cb392eca30f2.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226093&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":163,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=226093","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226093&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1607671339000,"playInfo":[],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":"四种气质","descriptionPgc":"NOWNESS Experiments: The Four Temperaments\n受古希腊哲学家盖伦（Galen）的启发，视频装置艺术家Marco Brambilla在他的最新短片《四种气质》中探讨了人类的处境。 主演奥斯卡金像奖得主凯特·布兰切特，Brambilla用颜色唤起四种幽默。 在这个引人入胜的四联画中，艺术家测试了是否可以使用同一位演员所说的两句对话来创作戏剧。 该项目是#UnrealCity的一部分，它是伦敦最大的增强现实展览。","remark":"NOWNESS Experiments: The Four Temperaments ","ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/e28df30686bcc37ac964dda1dee6259c.mp4","fileSizeStr":"1.74MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"受古希腊哲学家盖伦「Galen」的启发，视频装置艺术家 Marco Brambilla 在他的最新短片「四种气质」中探讨了人类的处境，由奥斯卡金像奖得主凯特·布兰切特主演。Brambilla 用颜色代表四种气质，凯特·布兰切特用多种情绪演绎「我爱你」这句话。该项目是「UnrealCity」活动的一部分，它是伦敦最大的增强现实展览。","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1}],"count":5,"adTrack":null,"footer":null}
     * trackingData : null
     * tag : null
     * id : 0
     * adIndex : -1
     */

    private String type;
    private DataBeanXX data;
    private Object trackingData;
    private Object tag;
    private int id;
    private int adIndex;

    @Override
    public int getItemType() {
        int type = 0;
        switch (getType()) {
            case "squareCardCollection":
                type = SQUARE_CARD_COLLECTION;
                break;
            case "autoPlayVideoAd":
                type = AUTO_PLAY_VIDEO_AD;
                break;
            case "textCard":
                type = TEXT_CARD;
                break;
            case "followCard":
                type = FOLLOW_CARD;
                break;
            case "videoSmallCard":
                type = VIDEO_SMALL_CARD;
                break;
            case "banner2":
                type = BANNER;
                break;
            default:
                break;
        }
        return type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBeanXX getData() {
        return data;
    }

    public void setData(DataBeanXX data) {
        this.data = data;
    }

    public Object getTrackingData() {
        return trackingData;
    }

    public void setTrackingData(Object trackingData) {
        this.trackingData = trackingData;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdIndex() {
        return adIndex;
    }

    public void setAdIndex(int adIndex) {
        this.adIndex = adIndex;
    }

    public static class DataBeanXX {
        /**
         * dataType : ItemCollection
         * header : {"id":5,"title":"开眼编辑精选","font":"bigBold","subTitle":"WEDNESDAY, DECEMBER 16","subTitleFont":"lobster","textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://feed?tabIndex=2","labelList":null,"rightText":"查看往期"}
         * itemList : [{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/2165/?title=%E5%BC%80%E7%9C%BC%E7%94%9F%E6%B4%BB%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","iconType":"round","description":null,"time":1608080400000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","description":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","library":"DAILY","tags":[{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null,"desc":"告诉他们为什么与众不同","bgPicture":"http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1234,"name":"时代周刊","actionUrl":"eyepetizer://tag/1234/?title=%E6%97%B6%E4%BB%A3%E5%91%A8%E5%88%8A","adTrack":null,"desc":"使\u201c忙人\u201d能够充分了解世界大事","bgPicture":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null,"desc":"匠心、健康、生活感悟","bgPicture":"http://img.kaiyanapp.com/95ba262a92ac99db76794ca56233d5d1.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/314a1e399de4c5708058e7f391619647.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1378,"name":"热爱生活的一万个理由","actionUrl":"eyepetizer://tag/1378/?title=%E7%83%AD%E7%88%B1%E7%94%9F%E6%B4%BB%E7%9A%84%E4%B8%80%E4%B8%87%E4%B8%AA%E7%90%86%E7%94%B1","adTrack":null,"desc":"值得爱的，有那么多","bgPicture":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":5}],"consumption":{"collectionCount":667,"shareCount":308,"replyCount":11,"realCollectionCount":242},"resourceType":"video","slogan":null,"provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"生活","author":{"id":2165,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","name":"开眼生活精选","description":"匠心、健康、生活感悟","link":"","latestReleaseTime":1604365206000,"videoNum":147,"adTrack":null,"follow":{"itemType":"author","itemId":2165,"followed":false},"shield":{"itemType":"author","itemId":2165,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/7c1683c778d58644cced74865284678f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":142,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=226195","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226195&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1608080400000,"playInfo":[{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":21587662},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":21587662}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/56fc3a74ea3724b5f389b634c0d0035a.mp4","fileSizeStr":"4.63MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":227322,"title":"首位获得金狮奖的中国女导演：「无依之地」","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/3145/?title=%E5%BD%B1%E8%A7%86%E6%9D%82%E5%9D%9B&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/5f0f992e79639d621aec91fe760a4836.jpeg?imageMogr2/quality/60/format/jpg","iconType":"round","description":"","time":1608080400000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":227322,"title":"首位获得金狮奖的中国女导演：「无依之地」","description":"「无依之地」（Nomadland）发布正式预告。赵婷凭借导演作品「无依之地」拿下威尼斯金狮奖，她也是史上第一位收获欧洲三大电影节的华人女导演，同时也是继张艺谋、贾樟柯之后，第三位内地金狮奖获得者。本片改编自同名小说，在经济大衰退中甚至失去了工作、失去了的 Fern 的流浪生活。本片由奥斯卡最佳女主角获得者弗兰西斯·麦克多蒙德主演，预计于 2021 年 2 月在北美上映。From SearchlightPictures","library":"DAILY","tags":[{"id":796,"name":"迷影放映室","actionUrl":"eyepetizer://tag/796/?title=%E8%BF%B7%E5%BD%B1%E6%94%BE%E6%98%A0%E5%AE%A4","adTrack":null,"desc":"电影、剧集、戏剧抢先看","bgPicture":"http://img.kaiyanapp.com/64f2b2ed039bd92c3be10d003d6041bf.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/56a8818adb038c59ab04ffc781db2f50.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":220,"name":"改编","actionUrl":"eyepetizer://tag/220/?title=%E6%94%B9%E7%BC%96","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/521d368604ee32280ae45b0fee729101.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bb85141514473b4f992923930b054d9a.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1398,"name":"文学改编电影","actionUrl":"eyepetizer://tag/1398/?title=%E6%96%87%E5%AD%A6%E6%94%B9%E7%BC%96%E7%94%B5%E5%BD%B1","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/d9ae20a50314f87d09c4737a7bc0ee0d.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/d9ae20a50314f87d09c4737a7bc0ee0d.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1025,"name":"影视","actionUrl":"eyepetizer://tag/1025/?title=%E5%BD%B1%E8%A7%86","adTrack":null,"desc":"电影、剧集、戏剧抢先看","bgPicture":"http://img.kaiyanapp.com/8a298964e7c9fc2ae16342832e36d88d.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/9d7fe42c1445031e4c8f2421b652a011.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":793,"name":"影视预告","actionUrl":"eyepetizer://tag/793/?title=%E5%BD%B1%E8%A7%86%E9%A2%84%E5%91%8A","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/66a25db995c30f130c433b2422111541.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/528bbba3db1e6388c4a97edce734a743.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1401,"name":"威尼斯电影节","actionUrl":"eyepetizer://tag/1401/?title=%E5%A8%81%E5%B0%BC%E6%96%AF%E7%94%B5%E5%BD%B1%E8%8A%82","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":265,"shareCount":175,"replyCount":6,"realCollectionCount":113},"resourceType":"video","slogan":"","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"影视","author":{"id":3145,"icon":"http://img.kaiyanapp.com/5f0f992e79639d621aec91fe760a4836.jpeg?imageMogr2/quality/60/format/jpg","name":"影视杂坛","description":"一个影视相关内容的大杂谈！","link":"","latestReleaseTime":1606924868000,"videoNum":700,"adTrack":null,"follow":{"itemType":"author","itemId":3145,"followed":false},"shield":{"itemType":"author","itemId":3145,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/42769d448409e8a276524a997e823b16.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/ecf6ce146102c3ece03e9208a85a0259.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=227322&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":"","duration":125,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=227322","forWeibo":"http://www.eyepetizer.net/detail.html?vid=227322"},"releaseTime":1608080400000,"playInfo":[],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":"","descriptionPgc":"","remark":"","ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/bc8ff3c9c529798ec32bf877ebb80d8b.mp4","fileSizeStr":"3.44MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"「无依之地」（Nomadland）发布正式预告。赵婷凭借导演作品「无依之地」拿下威尼斯金狮奖，她也是史上第一位收获欧洲三大电影节的华人女导演，同时也是继张艺谋、贾樟柯之后，第三位内地金狮奖获得者。本片改编自同名小说，在经济大衰退中甚至失去了工作、失去了的 Fern 的流浪生活。本片由奥斯卡最佳女主角获得者弗兰西斯·麦克多蒙德主演，预计于 2021 年 2 月在北美上映。From SearchlightPictures","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":54589,"title":"在极光下冲浪，在严寒中燃烧生命","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/447/?title=%E6%AC%A7%E6%B4%B2%E6%97%85%E8%A1%8C%E7%B2%BE%E9%80%89%E8%A7%86%E9%A2%91&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/85360a00de6f3c4dbdf46e65beec8b35.png?imageMogr2/quality/60/format/jpg","iconType":"round","description":null,"time":1506765519000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":54589,"title":"在极光下冲浪，在严寒中燃烧生命","description":"视频拍摄于罗弗敦群岛，这是位于挪威北部的一个神奇岛屿，位于北极圈内，它拥有世上最大的深水珊瑚礁，以及数以百万记的海鸟，更因其远离喧嚣闻名于世。视频里冲浪的人们，真正的厉害，因为罗弗敦群岛是全球位置最北的冲浪地，可想而知的严寒。From Vincent Urban","library":"DAILY","tags":[{"id":10,"name":"跟着开眼看世界","actionUrl":"eyepetizer://tag/10/?title=%E8%B7%9F%E7%9D%80%E5%BC%80%E7%9C%BC%E7%9C%8B%E4%B8%96%E7%95%8C","adTrack":null,"desc":"去你想去的地方，发现世界的美","bgPicture":"http://img.kaiyanapp.com/7ea328a893aa1f092b9328a53494a267.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":14},{"id":1091,"name":"趁盛夏去放假","actionUrl":"eyepetizer://tag/1091/?title=%E8%B6%81%E7%9B%9B%E5%A4%8F%E5%8E%BB%E6%94%BE%E5%81%87","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/f280043e9df9cf4d6da416d2714e7a08.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f280043e9df9cf4d6da416d2714e7a08.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1019,"name":"旅行","actionUrl":"eyepetizer://tag/1019/?title=%E6%97%85%E8%A1%8C","adTrack":null,"desc":"世界这么大，总有你的目的地","bgPicture":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":370,"name":"欧洲","actionUrl":"eyepetizer://tag/370/?title=%E6%AC%A7%E6%B4%B2","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/e5f917d0a272dd19672e7c67e44084d2.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e5f917d0a272dd19672e7c67e44084d2.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":52,"name":"风光大片","actionUrl":"eyepetizer://tag/52/?title=%E9%A3%8E%E5%85%89%E5%A4%A7%E7%89%87","adTrack":null,"desc":"","bgPicture":"http://img.kaiyanapp.com/e484dd6aa22ea3c2e604812b44f8c60c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/f333f225c9ccc78819120f3a888b2e7e.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":728,"shareCount":468,"replyCount":10,"realCollectionCount":64},"resourceType":"video","slogan":null,"provider":{"name":"定制来源","alias":"CustomSrc","icon":""},"category":"旅行","author":{"id":447,"icon":"http://img.kaiyanapp.com/85360a00de6f3c4dbdf46e65beec8b35.png?imageMogr2/quality/60/format/jpg","name":"欧洲旅行精选视频","description":"透过影像漫游欧洲","link":"","latestReleaseTime":1574524819000,"videoNum":0,"adTrack":null,"follow":{"itemType":"author","itemId":447,"followed":false},"shield":{"itemType":"author","itemId":447,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/660597ff0fc40da9f67156558d099a28.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/660597ff0fc40da9f67156558d099a28.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/0a61ca686fc575aba436a921c1a007e4.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":151,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=54589","forWeibo":"http://wandou.im/3oe3oq"},"releaseTime":1506765519000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=","size":12824081},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss&udid=","size":12824081}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid="},{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":23080263},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":23080263}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=54589&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":"","descriptionPgc":"","remark":"即使身处严寒，生命依旧燃烧","ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/c886979b464e42c0ca71b4543a09de7b.mp4","fileSizeStr":"3.54MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"视频拍摄于罗弗敦群岛，这是位于挪威北部的一个神奇岛屿，位于北极圈内，它拥有世上最大的深水珊瑚礁，以及数以百万记的海鸟，更因其远离喧嚣闻名于世。视频里冲浪的人们，真正的厉害，因为罗弗敦群岛是全球位置最北的冲浪地，可想而知的严寒。From Vincent Urban","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":225984,"title":"创意爽片｜原来设计灵感都源于生活","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/2161/?title=%E5%BC%80%E7%9C%BC%E5%88%9B%E6%84%8F%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/f4a9aba1c6857ee0cefcdc5aee0a1fc9.png?imageMogr2/quality/60/format/jpg","iconType":"round","description":null,"time":1608080400000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":225984,"title":"创意爽片｜原来设计灵感都源于生活","description":"这则动画将生活中的元素移动变换，迸发创意灵感。小球在管道中穿梭，牙齿在模拟牙床上浮动。基础图形穿插重叠，形成新的 Logo 设计。气球虽然爆炸，但却散落出明亮的碎片。将视角放大，在生活中寻找创意。换个角度看世界，就能获得全新的灵感。From TIMEON","library":"DAILY","tags":[{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":56,"name":"3D","actionUrl":"eyepetizer://tag/56/?title=3D","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/8648e4ce51da8444039ef046194fd6c8.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/8648e4ce51da8444039ef046194fd6c8.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":490,"name":"脑洞","actionUrl":"eyepetizer://tag/490/?title=%E8%84%91%E6%B4%9E","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/c8ac7bb1fa9276ce647d4687d93dea34.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/c8ac7bb1fa9276ce647d4687d93dea34.png?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":684,"name":"设计","actionUrl":"eyepetizer://tag/684/?title=%E8%AE%BE%E8%AE%A1","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/35ad4c34a1504cd8d398b315453a0f69.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1023,"name":"动画","actionUrl":"eyepetizer://tag/1023/?title=%E5%8A%A8%E7%94%BB","adTrack":null,"desc":"有趣的人永远不缺童心","bgPicture":"http://img.kaiyanapp.com/349cbd33cdf71fc74d5e9c7a00b444fd.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/208aa67386c045497389f015ae28dd29.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":181,"shareCount":112,"replyCount":6,"realCollectionCount":80},"resourceType":"video","slogan":null,"provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"创意","author":{"id":2161,"icon":"http://img.kaiyanapp.com/f4a9aba1c6857ee0cefcdc5aee0a1fc9.png?imageMogr2/quality/60/format/jpg","name":"开眼创意精选","description":"技术与审美结合，探索视觉的无限可能","link":"","latestReleaseTime":1606957209000,"videoNum":0,"adTrack":null,"follow":{"itemType":"author","itemId":2161,"followed":false},"shield":{"itemType":"author","itemId":2161,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/a4ac0a7cf120ab2249880fa7b7cf1e9b.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/a4ac0a7cf120ab2249880fa7b7cf1e9b.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/87011075c669d3d9fc76bc8f6cae404e.png?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/a4ac0a7cf120ab2249880fa7b7cf1e9b.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=225984&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":66,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=225984","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=225984&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1608080400000,"playInfo":[],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/5aa9ce0ef718dd533fadd72ad0599c9b.mp4","fileSizeStr":"3.09MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"这则动画将生活中的元素移动变换，迸发创意灵感。小球在管道中穿梭，牙齿在模拟牙床上浮动。基础图形穿插重叠，形成新的 Logo 设计。气球虽然爆炸，但却散落出明亮的碎片。将视角放大，在生活中寻找创意。换个角度看世界，就能获得全新的灵感。From TIMEON","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1},{"type":"followCard","data":{"dataType":"FollowCard","header":{"id":226093,"title":"凯特·布兰切特：用 100 种方式说我爱你","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/168/?title=NOWNESS%E7%8E%B0%E5%9C%A8&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/31588812d55435318fef0983e09a19a2.jpeg?imageMogr2/quality/60","iconType":"round","description":null,"time":1607671339000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":226093,"title":"凯特·布兰切特：用 100 种方式说我爱你","description":"受古希腊哲学家盖伦「Galen」的启发，视频装置艺术家 Marco Brambilla 在他的最新短片「四种气质」中探讨了人类的处境，由奥斯卡金像奖得主凯特·布兰切特主演。Brambilla 用颜色代表四种气质，凯特·布兰切特用多种情绪演绎「我爱你」这句话。该项目是「UnrealCity」活动的一部分，它是伦敦最大的增强现实展览。","library":"DAILY","tags":[{"id":744,"name":"每日创意灵感","actionUrl":"eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg","tagRecType":"IMPORTANT","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":2,"name":"创意","actionUrl":"eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F","adTrack":null,"desc":"技术与审美结合，探索视觉的无限可能","bgPicture":"http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":94,"name":"实验性","actionUrl":"eyepetizer://tag/94/?title=%E5%AE%9E%E9%AA%8C%E6%80%A7","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/e1a1a2b35f6916636594fe6bff4c5050.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/4aae1da4cea59eb15007e8d306c6eaea.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0}],"consumption":{"collectionCount":976,"shareCount":272,"replyCount":8,"realCollectionCount":418},"resourceType":"video","slogan":null,"provider":{"name":"PGC","alias":"PGC","icon":""},"category":"创意","author":{"id":168,"icon":"http://img.kaiyanapp.com/31588812d55435318fef0983e09a19a2.jpeg?imageMogr2/quality/60","name":"NOWNESS现在","description":"全球创意生活短片平台","link":"","latestReleaseTime":1608024806000,"videoNum":166,"adTrack":null,"follow":{"itemType":"author","itemId":168,"followed":false},"shield":{"itemType":"author","itemId":168,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/3da4dbe8d4145b750f32b4389be92b5a.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/3da4dbe8d4145b750f32b4389be92b5a.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/cad113345336fb9c9b73cb392eca30f2.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226093&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":163,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=226093","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226093&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1607671339000,"playInfo":[],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":"四种气质","descriptionPgc":"NOWNESS Experiments: The Four Temperaments\n受古希腊哲学家盖伦（Galen）的启发，视频装置艺术家Marco Brambilla在他的最新短片《四种气质》中探讨了人类的处境。 主演奥斯卡金像奖得主凯特·布兰切特，Brambilla用颜色唤起四种幽默。 在这个引人入胜的四联画中，艺术家测试了是否可以使用同一位演员所说的两句对话来创作戏剧。 该项目是#UnrealCity的一部分，它是伦敦最大的增强现实展览。","remark":"NOWNESS Experiments: The Four Temperaments ","ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/e28df30686bcc37ac964dda1dee6259c.mp4","fileSizeStr":"1.74MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"受古希腊哲学家盖伦「Galen」的启发，视频装置艺术家 Marco Brambilla 在他的最新短片「四种气质」中探讨了人类的处境，由奥斯卡金像奖得主凯特·布兰切特主演。Brambilla 用颜色代表四种气质，凯特·布兰切特用多种情绪演绎「我爱你」这句话。该项目是「UnrealCity」活动的一部分，它是伦敦最大的增强现实展览。","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]},"trackingData":null,"tag":null,"id":0,"adIndex":-1}]
         * count : 5
         * adTrack : null
         * footer : null
         */

        private String dataType;
        private HeaderBean header;
        private int count;
        private Object adTrack;
        private Object footer;
        private List<ItemListBean> itemList;

        private String title;
        private String description;
        private String text;
        private DetailBean detail;
        private String image;
        private ItemListBean.DataBeanX.ContentBean.DataBean.CoverBean cover;
        private ItemListBean.DataBeanX.ContentBean content;

        public ItemListBean.DataBeanX.ContentBean.DataBean.CoverBean getCover() {
            return cover;
        }

        public void setCover(ItemListBean.DataBeanX.ContentBean.DataBean.CoverBean cover) {
            this.cover = cover;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public ItemListBean.DataBeanX.ContentBean getContent() {
            return content;
        }

        public void setContent(ItemListBean.DataBeanX.ContentBean content) {
            this.content = content;
        }

        public static class DetailBean{
            private int id;
            private String icon;
            private String title;
            private String description;
            private String url;
            private String imageUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public Object getFooter() {
            return footer;
        }

        public void setFooter(Object footer) {
            this.footer = footer;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class HeaderBean {
            /**
             * id : 5
             * title : 开眼编辑精选
             * font : bigBold
             * subTitle : WEDNESDAY, DECEMBER 16
             * subTitleFont : lobster
             * textAlign : left
             * cover : null
             * label : null
             * actionUrl : eyepetizer://feed?tabIndex=2
             * labelList : null
             * rightText : 查看往期
             */

            private int id;
            private String title;
            private String font;
            private String subTitle;
            private String subTitleFont;
            private String textAlign;
            private Object cover;
            private Object label;
            private String actionUrl;
            private Object labelList;
            private String rightText;
            private String icon;
            private String description;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFont() {
                return font;
            }

            public void setFont(String font) {
                this.font = font;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getSubTitleFont() {
                return subTitleFont;
            }

            public void setSubTitleFont(String subTitleFont) {
                this.subTitleFont = subTitleFont;
            }

            public String getTextAlign() {
                return textAlign;
            }

            public void setTextAlign(String textAlign) {
                this.textAlign = textAlign;
            }

            public Object getCover() {
                return cover;
            }

            public void setCover(Object cover) {
                this.cover = cover;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public Object getLabelList() {
                return labelList;
            }

            public void setLabelList(Object labelList) {
                this.labelList = labelList;
            }

            public String getRightText() {
                return rightText;
            }

            public void setRightText(String rightText) {
                this.rightText = rightText;
            }
        }

        public static class ItemListBean {
            /**
             * type : followCard
             * data : {"dataType":"FollowCard","header":{"id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/2165/?title=%E5%BC%80%E7%9C%BC%E7%94%9F%E6%B4%BB%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","iconType":"round","description":null,"time":1608080400000,"showHateVideo":false},"content":{"type":"video","data":{"dataType":"VideoBeanForClient","id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","description":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","library":"DAILY","tags":[{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null,"desc":"告诉他们为什么与众不同","bgPicture":"http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1234,"name":"时代周刊","actionUrl":"eyepetizer://tag/1234/?title=%E6%97%B6%E4%BB%A3%E5%91%A8%E5%88%8A","adTrack":null,"desc":"使\u201c忙人\u201d能够充分了解世界大事","bgPicture":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null,"desc":"匠心、健康、生活感悟","bgPicture":"http://img.kaiyanapp.com/95ba262a92ac99db76794ca56233d5d1.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/314a1e399de4c5708058e7f391619647.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1378,"name":"热爱生活的一万个理由","actionUrl":"eyepetizer://tag/1378/?title=%E7%83%AD%E7%88%B1%E7%94%9F%E6%B4%BB%E7%9A%84%E4%B8%80%E4%B8%87%E4%B8%AA%E7%90%86%E7%94%B1","adTrack":null,"desc":"值得爱的，有那么多","bgPicture":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":5}],"consumption":{"collectionCount":667,"shareCount":308,"replyCount":11,"realCollectionCount":242},"resourceType":"video","slogan":null,"provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"生活","author":{"id":2165,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","name":"开眼生活精选","description":"匠心、健康、生活感悟","link":"","latestReleaseTime":1604365206000,"videoNum":147,"adTrack":null,"follow":{"itemType":"author","itemId":2165,"followed":false},"shield":{"itemType":"author","itemId":2165,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/7c1683c778d58644cced74865284678f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":142,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=226195","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226195&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1608080400000,"playInfo":[{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":21587662},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":21587662}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/56fc3a74ea3724b5f389b634c0d0035a.mp4","fileSizeStr":"4.63MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1},"adTrack":[]}
             * trackingData : null
             * tag : null
             * id : 0
             * adIndex : -1
             */

            private String type;
            private DataBeanX data;
            private Object trackingData;
            private Object tag;
            private int id;
            private int adIndex;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public DataBeanX getData() {
                return data;
            }

            public void setData(DataBeanX data) {
                this.data = data;
            }

            public Object getTrackingData() {
                return trackingData;
            }

            public void setTrackingData(Object trackingData) {
                this.trackingData = trackingData;
            }

            public Object getTag() {
                return tag;
            }

            public void setTag(Object tag) {
                this.tag = tag;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAdIndex() {
                return adIndex;
            }

            public void setAdIndex(int adIndex) {
                this.adIndex = adIndex;
            }

            public static class DataBeanX {
                /**
                 * dataType : FollowCard
                 * header : {"id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":"eyepetizer://pgc/detail/2165/?title=%E5%BC%80%E7%9C%BC%E7%94%9F%E6%B4%BB%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1","labelList":null,"rightText":null,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","iconType":"round","description":null,"time":1608080400000,"showHateVideo":false}
                 * content : {"type":"video","data":{"dataType":"VideoBeanForClient","id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","description":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","library":"DAILY","tags":[{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null,"desc":"告诉他们为什么与众不同","bgPicture":"http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1234,"name":"时代周刊","actionUrl":"eyepetizer://tag/1234/?title=%E6%97%B6%E4%BB%A3%E5%91%A8%E5%88%8A","adTrack":null,"desc":"使\u201c忙人\u201d能够充分了解世界大事","bgPicture":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null,"desc":"匠心、健康、生活感悟","bgPicture":"http://img.kaiyanapp.com/95ba262a92ac99db76794ca56233d5d1.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/314a1e399de4c5708058e7f391619647.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1378,"name":"热爱生活的一万个理由","actionUrl":"eyepetizer://tag/1378/?title=%E7%83%AD%E7%88%B1%E7%94%9F%E6%B4%BB%E7%9A%84%E4%B8%80%E4%B8%87%E4%B8%AA%E7%90%86%E7%94%B1","adTrack":null,"desc":"值得爱的，有那么多","bgPicture":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":5}],"consumption":{"collectionCount":667,"shareCount":308,"replyCount":11,"realCollectionCount":242},"resourceType":"video","slogan":null,"provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"生活","author":{"id":2165,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","name":"开眼生活精选","description":"匠心、健康、生活感悟","link":"","latestReleaseTime":1604365206000,"videoNum":147,"adTrack":null,"follow":{"itemType":"author","itemId":2165,"followed":false},"shield":{"itemType":"author","itemId":2165,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/7c1683c778d58644cced74865284678f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":142,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=226195","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226195&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1608080400000,"playInfo":[{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":21587662},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":21587662}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/56fc3a74ea3724b5f389b634c0d0035a.mp4","fileSizeStr":"4.63MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null},"trackingData":null,"tag":null,"id":0,"adIndex":-1}
                 * adTrack : []
                 */

                private String dataType;
                private HeaderBeanX header;
                private ContentBean content;
                private List<?> adTrack;

                public String getDataType() {
                    return dataType;
                }

                public void setDataType(String dataType) {
                    this.dataType = dataType;
                }

                public HeaderBeanX getHeader() {
                    return header;
                }

                public void setHeader(HeaderBeanX header) {
                    this.header = header;
                }

                public ContentBean getContent() {
                    return content;
                }

                public void setContent(ContentBean content) {
                    this.content = content;
                }

                public List<?> getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(List<?> adTrack) {
                    this.adTrack = adTrack;
                }

                public static class HeaderBeanX {
                    /**
                     * id : 226195
                     * title : 「时代周刊」回顾 2020：困难使我们强大
                     * font : null
                     * subTitle : null
                     * subTitleFont : null
                     * textAlign : left
                     * cover : null
                     * label : null
                     * actionUrl : eyepetizer://pgc/detail/2165/?title=%E5%BC%80%E7%9C%BC%E7%94%9F%E6%B4%BB%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1
                     * labelList : null
                     * rightText : null
                     * icon : http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg
                     * iconType : round
                     * description : null
                     * time : 1608080400000
                     * showHateVideo : false
                     */

                    private int id;
                    private String title;
                    private Object font;
                    private Object subTitle;
                    private Object subTitleFont;
                    private String textAlign;
                    private Object cover;
                    private Object label;
                    private String actionUrl;
                    private Object labelList;
                    private Object rightText;
                    private String icon;
                    private String iconType;
                    private Object description;
                    private long time;
                    private boolean showHateVideo;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public Object getFont() {
                        return font;
                    }

                    public void setFont(Object font) {
                        this.font = font;
                    }

                    public Object getSubTitle() {
                        return subTitle;
                    }

                    public void setSubTitle(Object subTitle) {
                        this.subTitle = subTitle;
                    }

                    public Object getSubTitleFont() {
                        return subTitleFont;
                    }

                    public void setSubTitleFont(Object subTitleFont) {
                        this.subTitleFont = subTitleFont;
                    }

                    public String getTextAlign() {
                        return textAlign;
                    }

                    public void setTextAlign(String textAlign) {
                        this.textAlign = textAlign;
                    }

                    public Object getCover() {
                        return cover;
                    }

                    public void setCover(Object cover) {
                        this.cover = cover;
                    }

                    public Object getLabel() {
                        return label;
                    }

                    public void setLabel(Object label) {
                        this.label = label;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public Object getLabelList() {
                        return labelList;
                    }

                    public void setLabelList(Object labelList) {
                        this.labelList = labelList;
                    }

                    public Object getRightText() {
                        return rightText;
                    }

                    public void setRightText(Object rightText) {
                        this.rightText = rightText;
                    }

                    public String getIcon() {
                        return icon;
                    }

                    public void setIcon(String icon) {
                        this.icon = icon;
                    }

                    public String getIconType() {
                        return iconType;
                    }

                    public void setIconType(String iconType) {
                        this.iconType = iconType;
                    }

                    public Object getDescription() {
                        return description;
                    }

                    public void setDescription(Object description) {
                        this.description = description;
                    }

                    public long getTime() {
                        return time;
                    }

                    public void setTime(long time) {
                        this.time = time;
                    }

                    public boolean isShowHateVideo() {
                        return showHateVideo;
                    }

                    public void setShowHateVideo(boolean showHateVideo) {
                        this.showHateVideo = showHateVideo;
                    }
                }

                public static class ContentBean {
                    /**
                     * type : video
                     * data : {"dataType":"VideoBeanForClient","id":226195,"title":"「时代周刊」回顾 2020：困难使我们强大","description":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","library":"DAILY","tags":[{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null,"desc":"告诉他们为什么与众不同","bgPicture":"http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1234,"name":"时代周刊","actionUrl":"eyepetizer://tag/1234/?title=%E6%97%B6%E4%BB%A3%E5%91%A8%E5%88%8A","adTrack":null,"desc":"使\u201c忙人\u201d能够充分了解世界大事","bgPicture":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null,"desc":"匠心、健康、生活感悟","bgPicture":"http://img.kaiyanapp.com/95ba262a92ac99db76794ca56233d5d1.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/314a1e399de4c5708058e7f391619647.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1378,"name":"热爱生活的一万个理由","actionUrl":"eyepetizer://tag/1378/?title=%E7%83%AD%E7%88%B1%E7%94%9F%E6%B4%BB%E7%9A%84%E4%B8%80%E4%B8%87%E4%B8%AA%E7%90%86%E7%94%B1","adTrack":null,"desc":"值得爱的，有那么多","bgPicture":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":5}],"consumption":{"collectionCount":667,"shareCount":308,"replyCount":11,"realCollectionCount":242},"resourceType":"video","slogan":null,"provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"生活","author":{"id":2165,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","name":"开眼生活精选","description":"匠心、健康、生活感悟","link":"","latestReleaseTime":1604365206000,"videoNum":147,"adTrack":null,"follow":{"itemType":"author","itemId":2165,"followed":false},"shield":{"itemType":"author","itemId":2165,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false},"cover":{"feed":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/7c1683c778d58644cced74865284678f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=","thumbPlayUrl":null,"duration":142,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=226195","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226195&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"},"releaseTime":1608080400000,"playInfo":[{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":21587662},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":21587662}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}],"campaign":null,"waterMarks":null,"ad":false,"adTrack":[],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"ifLimitVideo":false,"searchWeight":0,"brandWebsiteInfo":null,"videoPosterBean":{"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/56fc3a74ea3724b5f389b634c0d0035a.mp4","fileSizeStr":"4.63MB"},"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1608080400000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME","collected":false,"reallyCollected":false,"played":false,"subtitles":[],"lastViewTime":null,"playlists":null,"src":null,"recallSource":null,"recall_source":null}
                     * trackingData : null
                     * tag : null
                     * id : 0
                     * adIndex : -1
                     */

                    private String type;
                    private DataBean data;
                    private Object trackingData;
                    private Object tag;
                    private int id;
                    private int adIndex;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public DataBean getData() {
                        return data;
                    }

                    public void setData(DataBean data) {
                        this.data = data;
                    }

                    public Object getTrackingData() {
                        return trackingData;
                    }

                    public void setTrackingData(Object trackingData) {
                        this.trackingData = trackingData;
                    }

                    public Object getTag() {
                        return tag;
                    }

                    public void setTag(Object tag) {
                        this.tag = tag;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getAdIndex() {
                        return adIndex;
                    }

                    public void setAdIndex(int adIndex) {
                        this.adIndex = adIndex;
                    }

                    public static class DataBean {
                        /**
                         * dataType : VideoBeanForClient
                         * id : 226195
                         * title : 「时代周刊」回顾 2020：困难使我们强大
                         * description : 2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME
                         * library : DAILY
                         * tags : [{"id":346,"name":"美国","actionUrl":"eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD","adTrack":null,"desc":null,"bgPicture":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":24,"name":"记录","actionUrl":"eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95","adTrack":null,"desc":"告诉他们为什么与众不同","bgPicture":"http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100","headerImage":"http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1234,"name":"时代周刊","actionUrl":"eyepetizer://tag/1234/?title=%E6%97%B6%E4%BB%A3%E5%91%A8%E5%88%8A","adTrack":null,"desc":"使\u201c忙人\u201d能够充分了解世界大事","bgPicture":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/e59186c259eb30eea49ea698b744d4ef.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":666,"name":"生活","actionUrl":"eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB","adTrack":null,"desc":"匠心、健康、生活感悟","bgPicture":"http://img.kaiyanapp.com/95ba262a92ac99db76794ca56233d5d1.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/314a1e399de4c5708058e7f391619647.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":0},{"id":1378,"name":"热爱生活的一万个理由","actionUrl":"eyepetizer://tag/1378/?title=%E7%83%AD%E7%88%B1%E7%94%9F%E6%B4%BB%E7%9A%84%E4%B8%80%E4%B8%87%E4%B8%AA%E7%90%86%E7%94%B1","adTrack":null,"desc":"值得爱的，有那么多","bgPicture":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","headerImage":"http://img.kaiyanapp.com/ae818132884655e72c6d65944e6ac03c.jpeg?imageMogr2/quality/60/format/jpg","tagRecType":"NORMAL","childTagList":null,"childTagIdList":null,"haveReward":false,"ifNewest":false,"newestEndTime":null,"communityIndex":5}]
                         * consumption : {"collectionCount":667,"shareCount":308,"replyCount":11,"realCollectionCount":242}
                         * resourceType : video
                         * slogan : null
                         * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
                         * category : 生活
                         * author : {"id":2165,"icon":"http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg","name":"开眼生活精选","description":"匠心、健康、生活感悟","link":"","latestReleaseTime":1604365206000,"videoNum":147,"adTrack":null,"follow":{"itemType":"author","itemId":2165,"followed":false},"shield":{"itemType":"author","itemId":2165,"shielded":false},"approvedNotReadyVideoCount":0,"ifPgc":true,"recSort":0,"expert":false}
                         * cover : {"feed":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/7c1683c778d58644cced74865284678f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
                         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
                         * thumbPlayUrl : null
                         * duration : 142
                         * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=226195","forWeibo":"https://m.eyepetizer.net/u1/video-detail?video_id=226195&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"}
                         * releaseTime : 1608080400000
                         * playInfo : [{"height":720,"width":1280,"urlList":[{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":21587662},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":21587662}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="}]
                         * campaign : null
                         * waterMarks : null
                         * ad : false
                         * adTrack : []
                         * type : NORMAL
                         * titlePgc : null
                         * descriptionPgc : null
                         * remark : null
                         * ifLimitVideo : false
                         * searchWeight : 0
                         * brandWebsiteInfo : null
                         * videoPosterBean : {"scale":0.725,"url":"http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/56fc3a74ea3724b5f389b634c0d0035a.mp4","fileSizeStr":"4.63MB"}
                         * idx : 0
                         * shareAdTrack : null
                         * favoriteAdTrack : null
                         * webAdTrack : null
                         * date : 1608080400000
                         * promotion : null
                         * label : null
                         * labelList : []
                         * descriptionEditor : 2020 是不平静的一年。这一年，世界各地的生命损失惨重。但是，这个世界仍然充满了同情心和爱心。「时代周刊」的这则视频回顾 2020 ，讲述了这一年当中的重大事件，包括疫情、民权运动等。影片致敬了在艰难时刻付出过的人，他们在屡次经历困难后，依旧充满着勇气。From TIME
                         * collected : false
                         * reallyCollected : false
                         * played : false
                         * subtitles : []
                         * lastViewTime : null
                         * playlists : null
                         * src : null
                         * recallSource : null
                         * recall_source : null
                         */

                        private String dataType;
                        private int id;
                        private String title;
                        private String description;
                        private String library;
                        private ConsumptionBean consumption;
                        private String resourceType;
                        private Object slogan;
                        private ProviderBean provider;
                        private String category;
                        private AuthorBean author;
                        private CoverBean cover;
                        private String playUrl;
                        private Object thumbPlayUrl;
                        private int duration;
                        private WebUrlBean webUrl;
                        private long releaseTime;
                        private Object campaign;
                        private Object waterMarks;
                        private boolean ad;
                        private String type;
                        private Object titlePgc;
                        private Object descriptionPgc;
                        private Object remark;
                        private boolean ifLimitVideo;
                        private int searchWeight;
                        private Object brandWebsiteInfo;
                        private VideoPosterBeanBean videoPosterBean;
                        private int idx;
                        private Object shareAdTrack;
                        private Object favoriteAdTrack;
                        private Object webAdTrack;
                        private long date;
                        private Object promotion;
                        private Object label;
                        private String descriptionEditor;
                        private boolean collected;
                        private boolean reallyCollected;
                        private boolean played;
                        private Object lastViewTime;
                        private Object playlists;
                        private Object src;
                        private Object recallSource;
                        private Object recall_source;
                        private List<TagsBean> tags;
                        private List<PlayInfoBean> playInfo;
                        private List<?> adTrack;
                        private List<?> labelList;
                        private List<?> subtitles;

                        public String getDataType() {
                            return dataType;
                        }

                        public void setDataType(String dataType) {
                            this.dataType = dataType;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public String getLibrary() {
                            return library;
                        }

                        public void setLibrary(String library) {
                            this.library = library;
                        }

                        public ConsumptionBean getConsumption() {
                            return consumption;
                        }

                        public void setConsumption(ConsumptionBean consumption) {
                            this.consumption = consumption;
                        }

                        public String getResourceType() {
                            return resourceType;
                        }

                        public void setResourceType(String resourceType) {
                            this.resourceType = resourceType;
                        }

                        public Object getSlogan() {
                            return slogan;
                        }

                        public void setSlogan(Object slogan) {
                            this.slogan = slogan;
                        }

                        public ProviderBean getProvider() {
                            return provider;
                        }

                        public void setProvider(ProviderBean provider) {
                            this.provider = provider;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public AuthorBean getAuthor() {
                            return author;
                        }

                        public void setAuthor(AuthorBean author) {
                            this.author = author;
                        }

                        public CoverBean getCover() {
                            return cover;
                        }

                        public void setCover(CoverBean cover) {
                            this.cover = cover;
                        }

                        public String getPlayUrl() {
                            return playUrl;
                        }

                        public void setPlayUrl(String playUrl) {
                            this.playUrl = playUrl;
                        }

                        public Object getThumbPlayUrl() {
                            return thumbPlayUrl;
                        }

                        public void setThumbPlayUrl(Object thumbPlayUrl) {
                            this.thumbPlayUrl = thumbPlayUrl;
                        }

                        public int getDuration() {
                            return duration;
                        }

                        public void setDuration(int duration) {
                            this.duration = duration;
                        }

                        public WebUrlBean getWebUrl() {
                            return webUrl;
                        }

                        public void setWebUrl(WebUrlBean webUrl) {
                            this.webUrl = webUrl;
                        }

                        public long getReleaseTime() {
                            return releaseTime;
                        }

                        public void setReleaseTime(long releaseTime) {
                            this.releaseTime = releaseTime;
                        }

                        public Object getCampaign() {
                            return campaign;
                        }

                        public void setCampaign(Object campaign) {
                            this.campaign = campaign;
                        }

                        public Object getWaterMarks() {
                            return waterMarks;
                        }

                        public void setWaterMarks(Object waterMarks) {
                            this.waterMarks = waterMarks;
                        }

                        public boolean isAd() {
                            return ad;
                        }

                        public void setAd(boolean ad) {
                            this.ad = ad;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public Object getTitlePgc() {
                            return titlePgc;
                        }

                        public void setTitlePgc(Object titlePgc) {
                            this.titlePgc = titlePgc;
                        }

                        public Object getDescriptionPgc() {
                            return descriptionPgc;
                        }

                        public void setDescriptionPgc(Object descriptionPgc) {
                            this.descriptionPgc = descriptionPgc;
                        }

                        public Object getRemark() {
                            return remark;
                        }

                        public void setRemark(Object remark) {
                            this.remark = remark;
                        }

                        public boolean isIfLimitVideo() {
                            return ifLimitVideo;
                        }

                        public void setIfLimitVideo(boolean ifLimitVideo) {
                            this.ifLimitVideo = ifLimitVideo;
                        }

                        public int getSearchWeight() {
                            return searchWeight;
                        }

                        public void setSearchWeight(int searchWeight) {
                            this.searchWeight = searchWeight;
                        }

                        public Object getBrandWebsiteInfo() {
                            return brandWebsiteInfo;
                        }

                        public void setBrandWebsiteInfo(Object brandWebsiteInfo) {
                            this.brandWebsiteInfo = brandWebsiteInfo;
                        }

                        public VideoPosterBeanBean getVideoPosterBean() {
                            return videoPosterBean;
                        }

                        public void setVideoPosterBean(VideoPosterBeanBean videoPosterBean) {
                            this.videoPosterBean = videoPosterBean;
                        }

                        public int getIdx() {
                            return idx;
                        }

                        public void setIdx(int idx) {
                            this.idx = idx;
                        }

                        public Object getShareAdTrack() {
                            return shareAdTrack;
                        }

                        public void setShareAdTrack(Object shareAdTrack) {
                            this.shareAdTrack = shareAdTrack;
                        }

                        public Object getFavoriteAdTrack() {
                            return favoriteAdTrack;
                        }

                        public void setFavoriteAdTrack(Object favoriteAdTrack) {
                            this.favoriteAdTrack = favoriteAdTrack;
                        }

                        public Object getWebAdTrack() {
                            return webAdTrack;
                        }

                        public void setWebAdTrack(Object webAdTrack) {
                            this.webAdTrack = webAdTrack;
                        }

                        public long getDate() {
                            return date;
                        }

                        public void setDate(long date) {
                            this.date = date;
                        }

                        public Object getPromotion() {
                            return promotion;
                        }

                        public void setPromotion(Object promotion) {
                            this.promotion = promotion;
                        }

                        public Object getLabel() {
                            return label;
                        }

                        public void setLabel(Object label) {
                            this.label = label;
                        }

                        public String getDescriptionEditor() {
                            return descriptionEditor;
                        }

                        public void setDescriptionEditor(String descriptionEditor) {
                            this.descriptionEditor = descriptionEditor;
                        }

                        public boolean isCollected() {
                            return collected;
                        }

                        public void setCollected(boolean collected) {
                            this.collected = collected;
                        }

                        public boolean isReallyCollected() {
                            return reallyCollected;
                        }

                        public void setReallyCollected(boolean reallyCollected) {
                            this.reallyCollected = reallyCollected;
                        }

                        public boolean isPlayed() {
                            return played;
                        }

                        public void setPlayed(boolean played) {
                            this.played = played;
                        }

                        public Object getLastViewTime() {
                            return lastViewTime;
                        }

                        public void setLastViewTime(Object lastViewTime) {
                            this.lastViewTime = lastViewTime;
                        }

                        public Object getPlaylists() {
                            return playlists;
                        }

                        public void setPlaylists(Object playlists) {
                            this.playlists = playlists;
                        }

                        public Object getSrc() {
                            return src;
                        }

                        public void setSrc(Object src) {
                            this.src = src;
                        }

                        public Object getRecallSource() {
                            return recallSource;
                        }

                        public void setRecallSource(Object recallSource) {
                            this.recallSource = recallSource;
                        }

                        public Object getRecall_source() {
                            return recall_source;
                        }

                        public void setRecall_source(Object recall_source) {
                            this.recall_source = recall_source;
                        }

                        public List<TagsBean> getTags() {
                            return tags;
                        }

                        public void setTags(List<TagsBean> tags) {
                            this.tags = tags;
                        }

                        public List<PlayInfoBean> getPlayInfo() {
                            return playInfo;
                        }

                        public void setPlayInfo(List<PlayInfoBean> playInfo) {
                            this.playInfo = playInfo;
                        }

                        public List<?> getAdTrack() {
                            return adTrack;
                        }

                        public void setAdTrack(List<?> adTrack) {
                            this.adTrack = adTrack;
                        }

                        public List<?> getLabelList() {
                            return labelList;
                        }

                        public void setLabelList(List<?> labelList) {
                            this.labelList = labelList;
                        }

                        public List<?> getSubtitles() {
                            return subtitles;
                        }

                        public void setSubtitles(List<?> subtitles) {
                            this.subtitles = subtitles;
                        }

                        public static class ConsumptionBean {
                            /**
                             * collectionCount : 667
                             * shareCount : 308
                             * replyCount : 11
                             * realCollectionCount : 242
                             */

                            private int collectionCount;
                            private int shareCount;
                            private int replyCount;
                            private int realCollectionCount;

                            public int getCollectionCount() {
                                return collectionCount;
                            }

                            public void setCollectionCount(int collectionCount) {
                                this.collectionCount = collectionCount;
                            }

                            public int getShareCount() {
                                return shareCount;
                            }

                            public void setShareCount(int shareCount) {
                                this.shareCount = shareCount;
                            }

                            public int getReplyCount() {
                                return replyCount;
                            }

                            public void setReplyCount(int replyCount) {
                                this.replyCount = replyCount;
                            }

                            public int getRealCollectionCount() {
                                return realCollectionCount;
                            }

                            public void setRealCollectionCount(int realCollectionCount) {
                                this.realCollectionCount = realCollectionCount;
                            }
                        }

                        public static class ProviderBean {
                            /**
                             * name : YouTube
                             * alias : youtube
                             * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
                             */

                            private String name;
                            private String alias;
                            private String icon;

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getAlias() {
                                return alias;
                            }

                            public void setAlias(String alias) {
                                this.alias = alias;
                            }

                            public String getIcon() {
                                return icon;
                            }

                            public void setIcon(String icon) {
                                this.icon = icon;
                            }
                        }

                        public static class AuthorBean {
                            /**
                             * id : 2165
                             * icon : http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg
                             * name : 开眼生活精选
                             * description : 匠心、健康、生活感悟
                             * link :
                             * latestReleaseTime : 1604365206000
                             * videoNum : 147
                             * adTrack : null
                             * follow : {"itemType":"author","itemId":2165,"followed":false}
                             * shield : {"itemType":"author","itemId":2165,"shielded":false}
                             * approvedNotReadyVideoCount : 0
                             * ifPgc : true
                             * recSort : 0
                             * expert : false
                             */

                            private int id;
                            private String icon;
                            private String name;
                            private String description;
                            private String link;
                            private long latestReleaseTime;
                            private int videoNum;
                            private Object adTrack;
                            private FollowBean follow;
                            private ShieldBean shield;
                            private int approvedNotReadyVideoCount;
                            private boolean ifPgc;
                            private int recSort;
                            private boolean expert;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getIcon() {
                                return icon;
                            }

                            public void setIcon(String icon) {
                                this.icon = icon;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getDescription() {
                                return description;
                            }

                            public void setDescription(String description) {
                                this.description = description;
                            }

                            public String getLink() {
                                return link;
                            }

                            public void setLink(String link) {
                                this.link = link;
                            }

                            public long getLatestReleaseTime() {
                                return latestReleaseTime;
                            }

                            public void setLatestReleaseTime(long latestReleaseTime) {
                                this.latestReleaseTime = latestReleaseTime;
                            }

                            public int getVideoNum() {
                                return videoNum;
                            }

                            public void setVideoNum(int videoNum) {
                                this.videoNum = videoNum;
                            }

                            public Object getAdTrack() {
                                return adTrack;
                            }

                            public void setAdTrack(Object adTrack) {
                                this.adTrack = adTrack;
                            }

                            public FollowBean getFollow() {
                                return follow;
                            }

                            public void setFollow(FollowBean follow) {
                                this.follow = follow;
                            }

                            public ShieldBean getShield() {
                                return shield;
                            }

                            public void setShield(ShieldBean shield) {
                                this.shield = shield;
                            }

                            public int getApprovedNotReadyVideoCount() {
                                return approvedNotReadyVideoCount;
                            }

                            public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
                                this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
                            }

                            public boolean isIfPgc() {
                                return ifPgc;
                            }

                            public void setIfPgc(boolean ifPgc) {
                                this.ifPgc = ifPgc;
                            }

                            public int getRecSort() {
                                return recSort;
                            }

                            public void setRecSort(int recSort) {
                                this.recSort = recSort;
                            }

                            public boolean isExpert() {
                                return expert;
                            }

                            public void setExpert(boolean expert) {
                                this.expert = expert;
                            }

                            public static class FollowBean {
                                /**
                                 * itemType : author
                                 * itemId : 2165
                                 * followed : false
                                 */

                                private String itemType;
                                private int itemId;
                                private boolean followed;

                                public String getItemType() {
                                    return itemType;
                                }

                                public void setItemType(String itemType) {
                                    this.itemType = itemType;
                                }

                                public int getItemId() {
                                    return itemId;
                                }

                                public void setItemId(int itemId) {
                                    this.itemId = itemId;
                                }

                                public boolean isFollowed() {
                                    return followed;
                                }

                                public void setFollowed(boolean followed) {
                                    this.followed = followed;
                                }
                            }

                            public static class ShieldBean {
                                /**
                                 * itemType : author
                                 * itemId : 2165
                                 * shielded : false
                                 */

                                private String itemType;
                                private int itemId;
                                private boolean shielded;

                                public String getItemType() {
                                    return itemType;
                                }

                                public void setItemType(String itemType) {
                                    this.itemType = itemType;
                                }

                                public int getItemId() {
                                    return itemId;
                                }

                                public void setItemId(int itemId) {
                                    this.itemId = itemId;
                                }

                                public boolean isShielded() {
                                    return shielded;
                                }

                                public void setShielded(boolean shielded) {
                                    this.shielded = shielded;
                                }
                            }
                        }

                        public static class CoverBean {
                            /**
                             * feed : http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg
                             * detail : http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageMogr2/quality/60/format/jpg
                             * blurred : http://img.kaiyanapp.com/7c1683c778d58644cced74865284678f.jpeg?imageMogr2/quality/60/format/jpg
                             * sharing : null
                             * homepage : http://img.kaiyanapp.com/4fd7b21d31c35b6b81082b8cafe99e5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                             */

                            private String feed;
                            private String detail;
                            private String blurred;
                            private Object sharing;
                            private String homepage;

                            public String getFeed() {
                                return feed;
                            }

                            public void setFeed(String feed) {
                                this.feed = feed;
                            }

                            public String getDetail() {
                                return detail;
                            }

                            public void setDetail(String detail) {
                                this.detail = detail;
                            }

                            public String getBlurred() {
                                return blurred;
                            }

                            public void setBlurred(String blurred) {
                                this.blurred = blurred;
                            }

                            public Object getSharing() {
                                return sharing;
                            }

                            public void setSharing(Object sharing) {
                                this.sharing = sharing;
                            }

                            public String getHomepage() {
                                return homepage;
                            }

                            public void setHomepage(String homepage) {
                                this.homepage = homepage;
                            }
                        }

                        public static class WebUrlBean {
                            /**
                             * raw : http://www.eyepetizer.net/detail.html?vid=226195
                             * forWeibo : https://m.eyepetizer.net/u1/video-detail?video_id=226195&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0
                             */

                            private String raw;
                            private String forWeibo;

                            public String getRaw() {
                                return raw;
                            }

                            public void setRaw(String raw) {
                                this.raw = raw;
                            }

                            public String getForWeibo() {
                                return forWeibo;
                            }

                            public void setForWeibo(String forWeibo) {
                                this.forWeibo = forWeibo;
                            }
                        }

                        public static class VideoPosterBeanBean {
                            /**
                             * scale : 0.725
                             * url : http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/56fc3a74ea3724b5f389b634c0d0035a.mp4
                             * fileSizeStr : 4.63MB
                             */

                            private double scale;
                            private String url;
                            private String fileSizeStr;

                            public double getScale() {
                                return scale;
                            }

                            public void setScale(double scale) {
                                this.scale = scale;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }

                            public String getFileSizeStr() {
                                return fileSizeStr;
                            }

                            public void setFileSizeStr(String fileSizeStr) {
                                this.fileSizeStr = fileSizeStr;
                            }
                        }

                        public static class TagsBean {
                            /**
                             * id : 346
                             * name : 美国
                             * actionUrl : eyepetizer://tag/346/?title=%E7%BE%8E%E5%9B%BD
                             * adTrack : null
                             * desc : null
                             * bgPicture : http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100
                             * headerImage : http://img.kaiyanapp.com/19b625e7277199ed752fe61a56a596f2.jpeg?imageMogr2/quality/100
                             * tagRecType : NORMAL
                             * childTagList : null
                             * childTagIdList : null
                             * haveReward : false
                             * ifNewest : false
                             * newestEndTime : null
                             * communityIndex : 0
                             */

                            private int id;
                            private String name;
                            private String actionUrl;
                            private Object adTrack;
                            private Object desc;
                            private String bgPicture;
                            private String headerImage;
                            private String tagRecType;
                            private Object childTagList;
                            private Object childTagIdList;
                            private boolean haveReward;
                            private boolean ifNewest;
                            private Object newestEndTime;
                            private int communityIndex;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getActionUrl() {
                                return actionUrl;
                            }

                            public void setActionUrl(String actionUrl) {
                                this.actionUrl = actionUrl;
                            }

                            public Object getAdTrack() {
                                return adTrack;
                            }

                            public void setAdTrack(Object adTrack) {
                                this.adTrack = adTrack;
                            }

                            public Object getDesc() {
                                return desc;
                            }

                            public void setDesc(Object desc) {
                                this.desc = desc;
                            }

                            public String getBgPicture() {
                                return bgPicture;
                            }

                            public void setBgPicture(String bgPicture) {
                                this.bgPicture = bgPicture;
                            }

                            public String getHeaderImage() {
                                return headerImage;
                            }

                            public void setHeaderImage(String headerImage) {
                                this.headerImage = headerImage;
                            }

                            public String getTagRecType() {
                                return tagRecType;
                            }

                            public void setTagRecType(String tagRecType) {
                                this.tagRecType = tagRecType;
                            }

                            public Object getChildTagList() {
                                return childTagList;
                            }

                            public void setChildTagList(Object childTagList) {
                                this.childTagList = childTagList;
                            }

                            public Object getChildTagIdList() {
                                return childTagIdList;
                            }

                            public void setChildTagIdList(Object childTagIdList) {
                                this.childTagIdList = childTagIdList;
                            }

                            public boolean isHaveReward() {
                                return haveReward;
                            }

                            public void setHaveReward(boolean haveReward) {
                                this.haveReward = haveReward;
                            }

                            public boolean isIfNewest() {
                                return ifNewest;
                            }

                            public void setIfNewest(boolean ifNewest) {
                                this.ifNewest = ifNewest;
                            }

                            public Object getNewestEndTime() {
                                return newestEndTime;
                            }

                            public void setNewestEndTime(Object newestEndTime) {
                                this.newestEndTime = newestEndTime;
                            }

                            public int getCommunityIndex() {
                                return communityIndex;
                            }

                            public void setCommunityIndex(int communityIndex) {
                                this.communityIndex = communityIndex;
                            }
                        }

                        public static class PlayInfoBean {
                            /**
                             * height : 720
                             * width : 1280
                             * urlList : [{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=","size":21587662},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=","size":21587662}]
                             * name : 高清
                             * type : high
                             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
                             */

                            private int height;
                            private int width;
                            private String name;
                            private String type;
                            private String url;
                            private List<UrlListBean> urlList;

                            public int getHeight() {
                                return height;
                            }

                            public void setHeight(int height) {
                                this.height = height;
                            }

                            public int getWidth() {
                                return width;
                            }

                            public void setWidth(int width) {
                                this.width = width;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getType() {
                                return type;
                            }

                            public void setType(String type) {
                                this.type = type;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }

                            public List<UrlListBean> getUrlList() {
                                return urlList;
                            }

                            public void setUrlList(List<UrlListBean> urlList) {
                                this.urlList = urlList;
                            }

                            public static class UrlListBean {
                                /**
                                 * name : aliyun
                                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=226195&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
                                 * size : 21587662
                                 */

                                private String name;
                                private String url;
                                private int size;

                                public String getName() {
                                    return name;
                                }

                                public void setName(String name) {
                                    this.name = name;
                                }

                                public String getUrl() {
                                    return url;
                                }

                                public void setUrl(String url) {
                                    this.url = url;
                                }

                                public int getSize() {
                                    return size;
                                }

                                public void setSize(int size) {
                                    this.size = size;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

