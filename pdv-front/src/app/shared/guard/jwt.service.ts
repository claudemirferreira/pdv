import {Injectable} from "@angular/core";

@Injectable()
export class JwtService {

  readonly TOKEN_KEY = 'jwtToken';

  getToken(): String {
    return window.localStorage[this.TOKEN_KEY];
  }

  saveToken(token: String) {
    window.localStorage[this.TOKEN_KEY] = token;
  }

  destroyToken() {
    window.localStorage.removeItem(this.TOKEN_KEY);
  }

}
