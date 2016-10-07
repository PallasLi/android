package com.pallasli.bpmoa;

import android.app.Activity;
import android.app.Fragment;

import com.pallasli.bpmoa.bpm.MyApplyListFragment;
import com.pallasli.bpmoa.bpm.MyApplyProcessListFragment;
import com.pallasli.bpmoa.bpm.MyDoneListFragment;
import com.pallasli.bpmoa.bpm.MyDraftListFragment;
import com.pallasli.bpmoa.bpm.MyTodoListFragment;
import com.pallasli.bpmoa.bpm.StartFragment;
import com.pallasli.bpmoa.community.UserInfoFragment;
import com.pallasli.bpmoa.community.ZoneFragment;
import com.pallasli.bpmoa.community.activity.NoticePublishFragment;
import com.pallasli.bpmoa.community.activity.OrgnizationActivityPublishFragment;
import com.pallasli.bpmoa.community.activity.VoteInitiateFragment;
import com.pallasli.bpmoa.community.im.ChatFragment;
import com.pallasli.bpmoa.community.im.FriendListFragment;
import com.pallasli.bpmoa.community.im.MobileLinkmanListFragment;
import com.pallasli.bpmoa.community.im.OrgnizationLinkmanListFragment;
import com.pallasli.bpmoa.community.im.QqLinkmanListFragment;
import com.pallasli.bpmoa.community.im.WebchatLinkmanListFragment;
import com.pallasli.bpmoa.community.zone.WorkGroupAddFragment;
import com.pallasli.bpmoa.community.zone.WorkGroupListFragment;
import com.pallasli.bpmoa.hr.AskForLeaveFragment;
import com.pallasli.bpmoa.community.im.FriendGroupListFragment;
import com.pallasli.bpmoa.personal.CareListFragment;
import com.pallasli.bpmoa.personal.DownloadFileListFragment;
import com.pallasli.bpmoa.personal.FavoriteListFragment;
import com.pallasli.bpmoa.personal.MessageListFragment;
import com.pallasli.bpmoa.personal.UploadFileListFragment;
import com.pallasli.bpmoa.personal.UserSettingFragment;
import com.pallasli.bpmoa.system.SettingFragment;
import com.pallasli.bpmoa.workbench.WorkbenchFragment;

/**
 * Created by lyt1987 on 16/10/2.
 */
public class HomeFragmentUtils {
    //流程
    /**
     * 我的待办
     *
     * @param activity
     */
    public static void openBpmMyTodoFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_bpm_my_todo, new MyTodoListFragment());
//        getMenuInflater().inflate(R.menu.home, menu);
    }

    /**
     * 我的已办
     *
     * @param activity
     */
    public static void openBpmMyDoneFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_bpm_my_done, new MyDoneListFragment());
    }

    /**
     * 我的申请
     *
     * @param activity
     */
    public static void openBpmMyApplyFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_bpm_my_apply, new MyApplyListFragment());
    }

    /**
     * 我的草稿
     *
     * @param activity
     */
    public static void openBpmMyDraftFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_bpm_my_draft, new MyDraftListFragment());
    }

    /**
     * 启动流程列表
     *
     * @param activity
     */
    public static void openBpmStartFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_bpm_start, new StartFragment());
    }

    /**
     * 请假申请
     *
     * @param activity
     */
    public static void openHrAskForLeaveFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_hr_ask_for_leave, new AskForLeaveFragment());
    }


    //系统

    /**
     * 系统--设置
     *
     * @param activity
     */
    public static void openSysSettingFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_sys_setting, new SettingFragment());
    }

    //个人

    /**
     * 个人--用户信息
     * @param activity
     */
    public static void openPersonalUserInfoFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_user_info, new UserInfoFragment());
    }

    /**
     * 个人--工作台
     * @param activity
     */
    public static void openPersonalWorkbenchFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_workbench, new WorkbenchFragment());
    }

    /**
     * 个人--我的消息列表
     *
     * @param activity
     */
    public static void openPersonalMessageListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_message_list, new MessageListFragment());
    }

    /**
     * 个人--我的关注列表
     *
     * @param activity
     */
    public static void openPersonalCareListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_care_list, new CareListFragment());
    }

    /**
     * 个人--我的下载列表
     *
     * @param activity
     */
    public static void openPersonalDownloadFileListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_download_file_list, new DownloadFileListFragment());
    }

    /**
     * 个人--我的上传列表
     *
     * @param activity
     */
    public static void openPersonalUploadFileListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_upload_file_list, new UploadFileListFragment());
    }

    /**
     * 个人--我的收藏列表
     *
     * @param activity
     */
    public static void openPersonalFavoriteListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_favorite_list, new FavoriteListFragment());
    }
    /**
     * 个人--我的设置
     *
     * @param activity
     */
    public static void openPersonalUserSettingFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_personal_setting, new UserSettingFragment());
    }


    //社交

    /**
     * 社交--IM-通讯录--我的好友--列表
     *
     * @param activity
     */
    public static void openCommunityImFriendListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_im_friend_list, new FriendListFragment());
    }

    /**
     * 社交--IM-通讯录--我的好友--分组
     *
     * @param activity
     */
    public static void openCommunityImFriendGroupListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_im_friend_group_list, new FriendGroupListFragment());
    }

    /**
     * 社交--IM-通讯录--单位联系人
     *
     * @param activity
     */
    public static void openCommunityImOrgnizationConcactsFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_im_orgnization_linkman_list, new OrgnizationLinkmanListFragment());
    }

    /**
     * 社交--IM-通讯录--手机联系人
     *
     * @param activity
     */
    public static void openCommunityImMobileConcactsFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_im_mobile_linkman_list, new MobileLinkmanListFragment());
    }

    /**
     * 社交--IM-通讯录--QQ联系人
     *
     * @param activity
     */
    public static void openCommunityImQQConcactsFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_im_qq_linkman_list, new QqLinkmanListFragment());
    }

    /**
     * 社交--IM-通讯录--微信联系人
     *
     * @param activity
     */
    public static void openCommunityImWebchatConcactsFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_im_webchat_linkman_list, new WebchatLinkmanListFragment());
    }

    /**
     * 社交--IM-聊天窗口
     *
     * @param activity
     */
    public static void openCommunityImChatFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_im_chat, new ChatFragment());
    }


    /**
     * 社交--朋友圈
     * @param activity
     */
    public static void openCommunityZoneFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_zone , new ZoneFragment());
    }

    /**
     * 社交--用户信息
     * @param activity
     */
    public static void openCommunityUserInfoFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_user_info , new UserInfoFragment());
    }

//    /**
//     * 社交--朋友圈--分组
//     * @param activity
//     */
//    public static void openCommunityZoneWorkGroupFragment(Activity activity) {
//        resetFragment(activity, R.string.fragment_community_zone_work_group, new ());
//    }

    /**
     * 社交--朋友圈--添加分组
     * @param activity
     */
    public static void openCommunityZoneWorkGroupAddFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_zone_work_group_add, new WorkGroupAddFragment());
    }

    /**
     * 社交--朋友圈--分组列表
     * @param activity
     */
    public static void openCommunityZoneWorkGroupListFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_zone_work_group_list, new WorkGroupListFragment());
    }

    //活动
    /**
     *  社交--活动--发起投票
     * @param activity
     */
    public static void openCommunityActivityVoteInitiateFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_activity_vote_initiate, new VoteInitiateFragment());
    }

    /**
     *  社交--活动--发布通知
     * @param activity
     */
    public static void openCommunityActivityNoticePublishFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_activity_notice_publish, new NoticePublishFragment());
    }

    /**
     * 社交--活动--发布组织活动
     * @param activity
     */
    public static void openCommunityActivityOrgnizationActivityPublishFragment(Activity activity) {
        resetFragment(activity, R.string.fragment_community_activity_orgnization_activity_publish, new OrgnizationActivityPublishFragment());
    }

    /**
     * 为指定的activity切换fragment，根据定义的字符串名称赋值
     *
     * @param title
     * @param fragment
     */
    private static void resetFragment(Activity activity, int title, Fragment fragment) {
        activity.setTitle(title);
        activity.getFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
    }

}
