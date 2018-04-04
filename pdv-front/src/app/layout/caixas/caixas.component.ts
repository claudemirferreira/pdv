import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Component, OnInit} from '@angular/core';
import {routerTransition} from '../../router.animations';
import {Router} from '@angular/router';
import {ModalDismissReasons, NgbModal, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';

import {Caixa} from '../../shared/model/caixa.model';
import {CaixasService} from './caixas.service';
import {Paginate} from "../../shared/model/paginated.model";

@Component({
  selector: 'app-caixas',
  templateUrl: './caixas.component.html',
  styleUrls: ['./caixas.component.scss'],
  animations: [routerTransition()]
})
export class CaixasComponent implements OnInit {

  caixa: Caixa;
  paginated: Paginate;
  caixaForm: FormGroup;
  closeResult: string;

  private modalRef: NgbModalRef;

  constructor(private form: FormBuilder,
              private router: Router,
              private service: CaixasService,
              private modalService: NgbModal) {
  }

  ngOnInit() {
    this.caixa = new Caixa();
    this.configureForm();
  }

  configureForm() {
    this.caixaForm = this.form.group({
      statusCaixa: [null, [Validators.required]]
    });
  }

  saveProduct(content) {
    this.service.saveCaixas(this.caixa).subscribe(
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
    this.caixa = new Caixa();
    this.caixaForm.reset();
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