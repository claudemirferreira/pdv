import {Component, OnInit} from "@angular/core";
import {routerTransition} from "../../router.animations";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Produto} from "../../shared/model/produto.model";
import {Router} from "@angular/router";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {ProductsService} from "./products.service";
import {ObjectsPaginated} from "../../shared/model/objects-paginated.model";

@Component({
  selector: 'app-products-search',
  templateUrl: './products-search.component.html',
  styleUrls: ['./products-search.component.scss'],
  animations: [routerTransition()]
})
export class ProductsSearchComponent implements OnInit {

  product: Produto;
  objects: ObjectsPaginated;
  productForm: FormGroup;


  constructor(private form: FormBuilder,
              private router: Router,
              private service: ProductsService,
              private modalService: NgbModal) {
  }

  ngOnInit() {
    this.product = new Produto();
    this.objects = new ObjectsPaginated();
    this.configureForm();
  }

  configureForm() {
    this.productForm = this.form.group({
      nome: [null, []],
      codigoBarra: [null, []]
    });
  }

  search() {
    console.log(this.product)
    this.service.searchProducts(this.product).subscribe(
      (data: any) => {
        this.objects = data;
        console.log(this.objects)
      },(data: any) =>  {
        console.log("Erro")
      }
    );

  }

  setPage(page: number) {
    console.log(page)
  }


}
