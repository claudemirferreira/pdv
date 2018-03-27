import {Component, OnInit} from "@angular/core";
import {routerTransition} from "../../router.animations";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Produto} from "../../shared/model/produto.model";
import {Router} from "@angular/router";
import {ModalDismissReasons, NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {ProductsService} from "./products.service";
import {ObjectsPaginated} from "../../shared/model/objects-paginated.model";

import * as _ from 'underscore';

@Component({
  selector: 'app-products-search',
  templateUrl: './products-search.component.html',
  styleUrls: ['./products-search.component.scss'],
  animations: [routerTransition()]
})
export class ProductsSearchComponent implements OnInit {

  private modalRef: NgbModalRef;

  product: Produto;
  objects: ObjectsPaginated;
  totalPagesArray: any[] = [];
  productForm: FormGroup;
  closeResult: string;

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

  search(page:number = 0, size: number = 5) {
    this.service.searchProducts(this.product, page).subscribe(
      (data: any) => {
        this.objects = data;
        this.configRange()
      },(data: any) =>  {
        console.log("Erro")
      }
    );
  }

  setPage(page: number) {
    if(page < 0 || page > this.objects.totalPages) {
      return;
    }

    this.objects.number = page;
    this.getElements(page)
  }

  removeProduct(id: number) {
    this.service.removeProduct(id).toPromise()
      .then(res => {
        this.setPage(this.objects.number)
      }, msg => {
        console.error(msg);
      })
  }

  openDeleteDialog(content) {
    this.modalRef = this.modalService.open(content);
    this.modalRef.result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getElements(page:number = 0, size: number = 5) {
    this.service.searchProducts(this.product, page).subscribe(
      (data: any) => {
        this.objects = data;
      },(data: any) =>  {
        console.log("Erro")
      }
    );
  }

  private configRange() {
    this.totalPagesArray = _.range(this.objects.number, this.objects.totalPages);
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
