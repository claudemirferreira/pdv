import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Auth } from '../../model/AuthModel';

@Component({
    selector: 'navigation',
    templateUrl: './navigation.component.html'
})

export class Navigation implements OnInit {

    @Input() loginInfo: Auth;
    constructor( private router: Router) { }

    ngOnInit() { }

    activeRoute(routename: string): boolean {
        return this.router.url.indexOf(routename) > -1;
    }

}
