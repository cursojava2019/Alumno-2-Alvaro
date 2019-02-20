import { Injectable } from '@angular/core';
import { MapType } from '@angular/compiler';
import { Profesor } from '../entities/profesor';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {
  url = 'http://localhost:8080/academiaWeb/services/profesores/';
  constructor(private http: HttpClient) {

  }

  findAll(): Observable<Profesor[]> {
    return this.http.get<Profesor[]>(this.url);
  }

  findById(id: number): Observable<Profesor> {
    console.log('id FindById ' + id);
    return this.http.get<Profesor>(this.url + id);
  }
  create(a: Profesor): Observable<Profesor> {
   return this.http.post<Profesor>(this.url, a);
  }
  delete(id: number): Observable<any> {
    return this.http.delete(this.url + id);
  }
  modificar(a: Profesor): Observable<any> {
    console.log(a);
    return this.http.put(this.url + a.id, a);
  }
}
