package com.fengniao.myblibli.bean.live;


import java.util.List;

public class LiveData {

    private List<LiveBanner> banner;
    private List<EntranceIcon> entranceIcons;
    private List<PartitionsBean> partitions;
    private List<Navigator> navigator;

    public List<LiveBanner> getBanner() {
        return banner;
    }

    public void setBanner(List<LiveBanner> banner) {
        this.banner = banner;
    }

    public List<EntranceIcon> getEntranceIcons() {
        return entranceIcons;
    }

    public void setEntranceIcons(List<EntranceIcon> entranceIcons) {
        this.entranceIcons = entranceIcons;
    }

    public List<PartitionsBean> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<PartitionsBean> partitions) {
        this.partitions = partitions;
    }

    public List<Navigator> getNavigator() {
        return navigator;
    }

    public void setNavigator(List<Navigator> navigator) {
        this.navigator = navigator;
    }

    public static class PartitionsBean {
        /**
         * partition : {"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?20170815165052","height":"63","width":"63"},"count":92}
         * lives : [{"owner":{"face":"http://i0.hdslb.com/bfs/face/19fc85057ba91141a59457c91a0fa71a0b84d6e7.jpg","mid":25256202,"name":"糖米兹"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f89d5b98ff6f68bced0f2184e60dc7e6d7bedaff.jpg","height":180,"width":320},"title":"【古风水彩 蛇妖】震惊！柚子巫改名了","room_id":79933,"check_version":0,"online":193,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/225602/live_25256202_5460444.flv?wsSecret=748cf3b9acc535a393324dd07937c397&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/effbe54414657ed89b2a48fd822abeed90d67f67.jpg","mid":2084445,"name":"污污_永远的魔法师_"},"cover":{"src":"http://i0.hdslb.com/bfs/live/af6b3f4fbb60f18704267ac044eb7180cf372304.jpg","height":180,"width":320},"title":"响爷","room_id":95974,"check_version":0,"online":4626,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/494677/live_2084445_6133208.flv?wsSecret=dc9f32b153f8cb1b9a74dc0c953233f2&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/20560a370063051fe78b8f441a4fc7234ab7b021.jpg","mid":7353072,"name":"剩少女"},"cover":{"src":"http://i0.hdslb.com/bfs/live/630a63b7a81ca874bb8e7cdf1684657eef044b7d.jpg","height":180,"width":320},"title":"剩少女 早安水彩 轰胜出军装点图","room_id":4405314,"check_version":0,"online":1367,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/589714/live_7353072_7447235.flv?wsSecret=d5ab5eff4716d58fc4da01d91f6b38ae&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/2feef28d962b0e5c8bbd573cffe84d5e13277747.jpg","mid":5030761,"name":"深井玑"},"cover":{"src":"http://i0.hdslb.com/bfs/live/86f52149ab7ced43cad509348c831f346608b8bd.jpg","height":180,"width":320},"title":"画汉子\u2044(\u2044 \u2044\u2022\u2044ω\u2044\u2022\u2044 \u2044)\u2044","room_id":95278,"check_version":0,"online":2258,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/612556/live_5030761_7103241.flv?wsSecret=08275ca6ad465691e3b134ea4e4ddec7&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/8a5649969c611ca42d8bc2162a69d9d1bcc7c158.jpg","mid":5475120,"name":"叮叮叮叮叮叮叮叮酱"},"cover":{"src":"http://i0.hdslb.com/bfs/live/de8c4d8ce35d3c2e510bd4ae964544280f5fdb80.jpg","height":180,"width":320},"title":"肝动画","room_id":78549,"check_version":0,"online":355,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/394439/live_5475120_7963379.flv?wsSecret=5deeb8c8974f08f5c4bfaaff16b43359&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/56157d60c8c2c0b8f7e137262bbb2e577c95c7a0.png","mid":5050136,"name":"Kirito丶桐人君"},"cover":{"src":"http://i0.hdslb.com/bfs/live/375e1b19a907b9cfa85dbd41f6ab98f6ac5a602a.jpg","height":180,"width":320},"title":"【初音未来H】初音庆生绘？本子？","room_id":73945,"check_version":0,"online":933,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/422537/live_5050136_7329209.flv?wsSecret=1fb22054f471cd8c65f5debc36f80438&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/0b5949615a360f49d4fe01951e7eb0c70416d960.jpg","mid":9617619,"name":"1号直播间"},"cover":{"src":"http://i0.hdslb.com/bfs/live/648acd78f6ebcb42462e6c2f84d262f7e532ef04.jpg","height":180,"width":320},"title":"正在直播夏日绘板活动 详情请查看简介哦","room_id":5440,"check_version":0,"online":4520,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/757649/live_9617619_6384511.flv?wsSecret=cf0a3b16250c4ab1c41b5a07527c32df&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/677ac77657535537ecd76f1051a11951e2be5164.jpg","mid":9871569,"name":"魔法少女小逝"},"cover":{"src":"http://i0.hdslb.com/bfs/live/e02e3b4f71fa8c57793d70fbccb6edbd5883d14a.jpg","height":180,"width":320},"title":"【声控福利】哇~各种姿势","room_id":73088,"check_version":0,"online":268,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/579/live_9871569_3091457.flv?wsSecret=01d0977163e8268ec6c958a4abeb58a5&wsTime=596d78fe","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/5ae8c75caeb5cb2338099c6b22b668f03bb2f72d.jpg","mid":4836885,"name":"酎六六六_"},"cover":{"src":"http://i0.hdslb.com/bfs/live/4162a6d4cadf4088a1e1fd7029bd40579dca8854.jpg","height":180,"width":320},"title":"气人主播每日关注-10","room_id":67223,"check_version":0,"online":103,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/727037/live_4836885_1208886.flv?wsSecret=9a85d36a5c68770d10aeccd64cfafd6b&wsTime=1502936822","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/03705b38c3cdc628b8d57e40bd6cf9e8c0288579.jpg","mid":13164495,"name":"壬木白"},"cover":{"src":"http://i0.hdslb.com/bfs/live/d2f83ab992e02f008028e0e51de15ddf2f31b2e9.jpg","height":180,"width":320},"title":"肝稿子","room_id":3072097,"check_version":0,"online":95,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/234/live_13164495_7159173.flv?wsSecret=2e881231a7402bfbd7c537f3e9fd3a1f&wsTime=596d78fe","accept_quality":"4","broadcast_type":0,"is_tv":0}]
         */

        private Partition partition;
        private List<Live> lives;

        public Partition getPartition() {
            return partition;
        }

        public void setPartition(Partition partition) {
            this.partition = partition;
        }

        public List<Live> getLives() {
            return lives;
        }

        public void setLives(List<Live> lives) {
            this.lives = lives;
        }

    }

}
