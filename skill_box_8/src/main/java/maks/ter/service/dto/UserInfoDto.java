package maks.ter.service.dto;


public class UserInfoDto {

    public Long id;

    public String firstName;
    public String midName;
    public String lastName;

    public String login;

    public UserInfoDto(Long id, String firstName, String midName, String lastName, String login) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.login = login;
    }
}
