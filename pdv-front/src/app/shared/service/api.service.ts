import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {JwtService} from "../guard/jwt.service";
import {ErrorObservable} from "rxjs/observable/ErrorObservable";
import {catchError} from "rxjs/operators";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs/Observable";


@Injectable()
export class ApiService {

  const; bearer: String = 'Bearer ';

  constructor(
    private http: HttpClient,
    private jwtService: JwtService
  ) {}

  private formatErrors(error: any) {
    return new ErrorObservable(error.json());
  }

  getHeader(): HttpHeaders {
    let token = this.bearer + "" + this.jwtService.getToken();
    let header = new HttpHeaders({'Authorization': token, 'Content-Type': 'application/json'});
    return header;
  }

  get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    let headers = this.getHeader();
    return this.http.get(`${environment.api_url}${path}`, {params, headers})
      .pipe(catchError(this.formatErrors));
  }

  put(path: string, body: Object = {}): Observable<any> {
    let headers = this.getHeader();
    return this.http.put(
      `${environment.api_url}${path}`,
      JSON.stringify(body),
      {headers: headers}
    ).pipe(catchError(this.formatErrors));
  }

  post(path: string, body: Object = {}): Observable<any> {
    return this.http.post(
      `${environment.api_url}${path}`,
      body,
      {headers: this.getHeader()}
    ).pipe(catchError(this.formatErrors));
  }

  delete(path): Observable<any> {
    let headers = this.getHeader();
    return this.http.delete(
      `${environment.api_url}${path}`,
      {headers: headers}
    ).pipe(catchError(this.formatErrors));
  }

}
