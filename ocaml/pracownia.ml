(*** PRACOWNIA 1 ***)


(* print_string "hello\n";; *)

let x = 5;;
let y = [(1, "ab");(2,"c")];;

let f x = x+1;;
let f (x,y) = x+2*y;;


(* 0! = 1, n! = n * (n+1) *)
let rec f n = if n = 0 then 1 
              else n * f(n-1);;

(* print_int (f 5);; *)


(* s(n,k) = n(n-k)(n-2k)(n-3k) *)


let rec s (n,k) = if n <= 0 then 1
                  else n * s(n-k, k);;
                  
(* print_int (s (10,3));; *)



let rec couple (l,x) = match l with
    | (a,b)::t -> if a = x then b else couple (t,x)
    | _ -> -1;;


(*
let l = [(1,2);(3,4);(5,6)];;
print_int (couple (l,1));;
print_string "\n";;
print_int (couple (l,3));;
print_string "\n";;
print_int (couple (l,4));;
*)



(*** PRACOWNIA 2 ***)


(* ZAD: odwracanie listy *)

let rec rev l = match l with
    | h::t -> (rev t)@[h]
    | _ -> [];;

let l1 = [1;2;3;4];;

(* (List.map print_int) (rev l1);; *)


(* ZAD: czy zadana lista jes palindromem *)

let pal l = if rev l = l then 1 else 0;;

(*
print_int (pal [1;2;2;1]);;
print_int (pal [1;2;1]);;
print_int (pal [1;2;3;4]);;
print_int (pal []);;
*)



(*** PRACOWNIA 3 ***)


(* ZAD1: potegowanie *)

let rec pot (a, n) = if n > 1 then a * pot(a, n-1)
                     else a;;

let rec potl (a, n) = if n = 0 then 1.0
                      else if n mod 2 = 0 then let z = potl(a, n/2) in z *. z
                      else a *. potl(a, n-1);;
                      
(* print_float (potl (2.0,10));; *)


(* ZAD2: pierwiastkowanie *)

let rec pierw (a, n, k) = if k = 0 then a
                          else let xk = pierw(a, n, k-1) in 
                          xk +. (1.0/.n *. (a/.(potl (xk, (int_of_float n)-1)) -. xk));;
                          
(* print_float (pierw (2.0,2.0,100));; *)



(*** PRACOWNIA 4 ***)


(* ZAD1: Drzewo BST przechowujace sam klucz *)

(*
type 'a option = Some of int | None;;
type 'b tree = Empty | Node of 'b * 'b tree * 'b tree;;

let root = Node (10, Empty, Empty);;

let rec insert (btree, x) = match btree with
    | Empty -> Node(x, Empty, Empty)
    | Node(y, left, right) -> if x <= y then Node(y, insert (left, x), right)
                              else Node(y, left, insert (right, x));;
*)

(* ZAD2: Drzewo BST przechowujace krotke *)

type 'a option = Some of 'a | None;;
type 'b tree = Empty | Node of 'b * 'b tree * 'b tree;;

let root = Node (Some (10, "Ala"), Empty, Empty);;

let rec insert (btree, Some (x, a)) = match btree with
    | Empty -> Node(Some (x, a), Empty, Empty)
    | Node(Some (y, b), left, right) -> if x <= y then Node(Some (y, b), insert (left, Some (x, a)), right)
                                        else Node(Some (y, b), left, insert (right, Some (x, a)));;


(*** PRACOWNIA 5 ***)

(* ZAD1: find dla drzewa BST *)

let rec find (btree, x) = match btree with
    | Empty -> None
    | Node(Some (y, b), left, right) -> if x == y then Some b 
                                        else if x < y then find(left, x)
                                        else find(right, y);;


let root2 = Node (Some (10, "Ala"), Node(Some (9, "kot"), Empty, Empty), Node(Some (11, "mysza"), Empty, Empty));;


(* ZAD2: Napisz metode ktora zamieni drzewo binarne na drzewo planarne *)


