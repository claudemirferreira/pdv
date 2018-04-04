import {Injectable} from '@angular/core';
import {Caixa} from '../../shared/model/caixa.model';
import {ApiService} from "../../shared/service/api.service";
import {HttpParams} from "@angular/common/http";

@Injectable()
export class CaixasService {
    constructor(private apiService: ApiService) {}

    saveCaixas(caixa: Caixa) {
        return this.apiService.post("/caixas",{caixa: caixa});
    }

    searchCaixas(caixa: Caixa) {
      let params = new HttpParams().set("statusCaixa", caixa.statusCaixa.toString());
      return this.apiService.get("/caixas/filter", params);
    }
}