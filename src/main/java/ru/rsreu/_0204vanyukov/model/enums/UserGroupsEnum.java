package ru.rsreu._0204vanyukov.model.enums;

import ru.rsreu._0204vanyukov.model.UserGroups;

public enum UserGroupsEnum {
    USER(1) {
        @Override
        public String getPage() {
            return "path.page.user_main";
        }
    },
    MODERATOR(2) {
        @Override
        public String getPage() {
            return "path.page.moderator_main";
        }
    },
    ADMINISTRATOR(3) {
        @Override
        public String getPage() {
            return "path.page.administrator_main";
        }
    };

    private int id;

    UserGroupsEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static UserGroupsEnum getUserGroupEnumFromUserGroupId(int userGroupId) {
        for (UserGroupsEnum userGroupsEnum : UserGroupsEnum.values()) {
            if (userGroupsEnum.getId() == userGroupId) {
                return userGroupsEnum;
            }
        }
        return null;
    }

    public abstract String getPage();
}
