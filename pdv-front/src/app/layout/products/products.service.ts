import {Injectable} from '@angular/core';
import {Produto} from '../../shared/model/produto.model';
import {ApiService} from "../../shared/service/api.service";
import {HttpParams} from "@angular/common/http";



@Injectable()
export class ProductsService {

    constructor(private apiService: ApiService) {}

    saveProducts(product: Produto) {
        return this.apiService.post("/produtos",{produto: product});
    }

    searchProducts(product: Produto, page: number = 0, size: number = 5) {
      let params = new HttpParams()
        .set("nome", product.nome)
        .set("codigoBarra", product.codigoBarra)
        .set("page", page.toString())
        .set("size", size.toString());
      return this.apiService.get("/produtos/filter", params);
    }

}
