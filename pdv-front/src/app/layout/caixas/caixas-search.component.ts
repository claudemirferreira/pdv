import {Component, OnInit} from "@angular/core";
import {routerTransition} from "../../router.animations";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Caixa} from "../../shared/model/caixa.model";
import {Router} from "@angular/router";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {CaixasService} from "./caixas.service";
import {ObjectsPaginated} from "../../shared/model/objects-paginated.model";

@Component({
  selector: 'app-caixas-search',
  templateUrl: './caixas-search.component.html',
  styleUrls: ['./caixas-search.component.scss'],
  animations: [routerTransition()]
})
export class CaixasSearchComponent implements OnInit {

  caixa: Caixa;
  objects: ObjectsPaginated;
  caixaForm: FormGroup;

  constructor(private form: FormBuilder,
              private router: Router,
              private service: CaixasService,
              private modalService: NgbModal) {
  }

  ngOnInit() {
    this.caixa = new Caixa();
    this.objects = new ObjectsPaginated();
    this.configureForm();
  }

  configureForm() {
    this.caixaForm = this.form.group({
      nome: [null, []],
      codigoBarra: [null, []]
    });
  }

  search() {
    console.log(this.caixa)
    this.service.searchCaixas(this.caixa).subscribe(
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