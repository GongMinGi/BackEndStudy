package com.example.secondBackendProject.dto;
import com.example.secondBackendProject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    private String email;
    private String password;

    public Member toEntity(MemberForm memberForm)
    {
        return new Member(null, email, password);
    }


}
