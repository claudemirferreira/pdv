import {Component, OnInit} from "@angular/core";
import {routerTransition} from "../../router.animations";

@Component({
  selector: 'app-products-search',
  templateUrl: './products-search.component.html',
  styleUrls: ['./products-search.component.scss'],
  animations: [routerTransition()]
})
export class ProductsSearchComponent implements OnInit {

  ngOnInit(): void {
  }

}
