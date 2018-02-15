import {Injectable} from '@angular/core';
import {Produto} from '../../shared/model/produto.model';
import {ApiService} from "../../shared/service/api.service";

@Injectable()
export class ProductsService {

    constructor(private apiService: ApiService) {}

    saveProducts(product: Produto) {
        return this.apiService.post("/produtos",{produto: product});
    }

}
