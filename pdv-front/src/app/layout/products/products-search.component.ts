import {Component, OnInit} from "@angular/core";
import {routerTransition} from "../../router.animations";
import {FormGroup} from "@angular/forms";
import {Produto} from "../../shared/model/produto.model";

@Component({
  selector: 'app-products-search',
  templateUrl: './products-search.component.html',
  styleUrls: ['./products-search.component.scss'],
  animations: [routerTransition()]
})
export class ProductsSearchComponent implements OnInit {

  product: Produto;
  productForm: FormGroup;

  ngOnInit(): void {
  }

}
