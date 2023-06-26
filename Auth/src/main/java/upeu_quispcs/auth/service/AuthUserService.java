package upeu_quispcs.auth.service;

import upeu_quispcs.auth.dto.AuthUserDto;
import upeu_quispcs.auth.entity.AuthUser;
import upeu_quispcs.auth.entity.TokenDto;

public interface AuthUserService {
    public AuthUser save(AuthUserDto authUserDto);

    public TokenDto login(AuthUserDto authUserDto);

    public TokenDto validate(String token);

}