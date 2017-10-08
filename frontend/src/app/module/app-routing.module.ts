import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {UserComponent} from "../component/user.component";
import {UserDetailComponent} from "../component/user-detail.component";
import {LoginFormComponent} from "../component/login-form.component";
import {GoodsComponent} from "../component/goods.component";
import {SignupFormComponent} from "../component/signup-form.component";
import {WorkspaceComponent} from "../component/workspace.component";
import {PageNotFoundComponent} from "../component/page-not-found.component";
import {GoodsDetailComponent} from "../component/goods-detail.component";

const routes: Routes = [
    {
        path: '',
        redirectTo: 'goods',
        pathMatch: 'full'
    },
    {
        path: 'users',
        component: UserComponent
    },
    {
        path: 'login',
        component: LoginFormComponent
    },
    {
        path: 'goods',
        component: GoodsComponent
    },
    {
        path: 'signup',
        component: SignupFormComponent
    },
    {
        path: 'workspace',
        component: WorkspaceComponent,
    },
    {
        path: 'user/:id',
        component: UserDetailComponent
    },
    {
        path: 'goods/:id',
        component: GoodsDetailComponent
    },
    {
        path: '**',
        component: PageNotFoundComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
