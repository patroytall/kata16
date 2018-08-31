package org.roy.kata16.entity;

public class MembershipOrderDetails {
    private final String membershipId;
    private final String userId;
    private final boolean upgrade;

    private MembershipOrderDetails(String membershipId, String userId, boolean upgrade) {
        this.membershipId = membershipId;
        this.userId = userId;
        this.upgrade = upgrade;
    }

    public static class Builder {
        private final String membershipId;
        private final String userId;
        private boolean upgrade;

        public Builder(String membershipId, String userId) {
            this.membershipId = membershipId;
            this.userId = userId;
        }

        public Builder setUpgrade() {
            upgrade = true;
            return this;
        }

        public MembershipOrderDetails build() {
            return new MembershipOrderDetails(membershipId, userId, upgrade);
        }
    }
}