package models.member;

public class ServiceManager {
    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() {
        JoinValidator joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao());

        return joinValidator;
    }

    public LoginValidator loginValidator() {
        return new LoginValidator(memberDao());
    }

    public JoinService getJoinService() {
        return new JoinService(memberDao(), joinValidator());
    }

    public LoginService getLoginService() {
        return new LoginService(memberDao(), loginValidator());
    }
}
