import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Component, OnInit, TemplateRef} from '@angular/core';
import {routerTransition} from '../../router.animations';
import {Router} from '@angular/router';
import {NgbModal, ModalDismissReasons, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';

import {Produto} from '../../shared/model/produto.model';
import {ProductsService} from './products.service';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
  animations: [routerTransition()]
})
export class ProductsComponent implements OnInit {

  product: Produto;
  productForm: FormGroup;
  closeResult: string;

  private formSumitAttempt: boolean;
  private modalRef: NgbModalRef;

  constructor(private form: FormBuilder,
              private router: Router,
              private service: ProductsService,
              private modalService: NgbModal) {
  }


  ngOnInit() {
    this.product = new Produto();
    this.configureForm();
  }

  configureForm() {
    this.productForm = this.form.group({
      nome: [null, [Validators.required]],
      precoVenda: [null, [Validators.required]],
      precoCusto: [null, [Validators.required]],
      codigoBarra: [null, [Validators.required]],
      medida: [null, [Validators.required]]
    });
  }

  isFieldValid(field: string) {
    return (
      (!this.productForm.get(field).valid && this.productForm.get(field).touched) ||
      (this.productForm.get(field).untouched && this.formSumitAttempt)
    );
  }

  saveProduct(content) {
    this.service.saveProducts(this.product).subscribe(
      (data: any) => {
        this.open(content);
        console.log("Save with success")
      },
      (data: any) => {
        console.log('Error on save product');
      }
    );
  }

  open(content) {
    this.modalRef = this.modalService.open(content);
    this.modalRef.result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  goToDashboard() {
    this.modalRef.close();
    this.router.navigateByUrl('/dashboard');
  }

  /**
   * TODO esconder o dialog
   * TODO retirar a validacao do form
   * @param content
   */
  clearForm(content:any) {
    this.product = new Produto();
    this.productForm.reset();
    this.modalRef.close();
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
