package com.leopoldhsing.horizon.model.vo;

import com.leopoldhsing.horizon.model.dto.UserDto;

import java.util.Objects;

public class UserSignInResponseVo {
    private UserDto user;
    private String token;

    public UserSignInResponseVo() {
    }

    public UserSignInResponseVo(UserDto user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSignInResponseVo that = (UserSignInResponseVo) o;
        return Objects.equals(user, that.user) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(user);
        result = 31 * result + Objects.hashCode(token);
        return result;
    }
}
