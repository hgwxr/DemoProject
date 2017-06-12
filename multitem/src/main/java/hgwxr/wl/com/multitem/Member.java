package hgwxr.wl.com.multitem;

/**
 * Created by Administrator on 2017/6/12.
 */

public class Member  extends  User {
        private   boolean  isMember;
        private  String  userPrivilege;

        public String getUserPrivilege() {
            return userPrivilege;
        }

        public void setUserPrivilege(String userPrivilege) {
            this.userPrivilege = userPrivilege;
        }

        public boolean isMember() {
            return isMember;
        }

        public void setMember(boolean member) {
            isMember = member;
        }

}
