(*
ZAD1:
definiowanie w�asnych typ�w danych:
type option = Some of(s�owo kluczowe) int(typ) | None ;;
type 'a option = Some of 'a | None;;
type 'b tree = Empty | Node of 'b * 'b tree * 'b tree // krotka 3-elementowa
drzewo BST
int * string option tree
insert(tree, int)
zr�b find - wyszukiwanie elementu
*)

type 'b tree = Empty | Node of 'b * 'b tree * 'b tree;;
type ('a1, 'a2) option = Some of 'a1 * 'a2 | None;;

let rec insert( s , tree ) =
	match s with 
	Some( k, w ) ->
		(	match tree with
			Node( Some( k1 , w1 ), l, r ) -> if k < k1 then Node( Some( k1 , w1 ) , insert( s, l ), r )
						else if k > k1 then Node( Some( k1 , w1 ) , l , insert( s, r) )
						else tree
			| Node( None , l , r ) -> tree
			| Empty -> Node( s , Empty , Empty ) )
	| None -> tree;;
	
let tt = insert( Some(3,"trzy") , insert( Some(2,"dwa") , insert( Some(5,"piec") , Empty) ) );;

(* ZAD2
Funkcja find. *)

let rec find  (k, tree) =
    match tree with
    | Node (Some(k1, w1),l ,r ) -> 
				if k == k1 then w1 
				else if k < k1 then find ( k, l )
				else find ( k , r )
	| Node( None , l , r ) -> "Nie znaleziono."
	| Empty -> "Nie znaleziono.";;
	
 print_string ( find( 1 , tt ) );; 

(* ZAD3
rozszerzenie binarnego - drzewo planarnego.
zdefiniowa� typ drzewa planarnego i funkcja przekszta�caj�ca drzewo binarne w planarne. 
wyk�ad 4 *)

type 'b tree = Empty | Node of 'b * 'b tree * 'b tree;;
type 'c ptree = LEmpty | LNode of 'c * 'c ptree list;;
type ('a1, 'a2) option = Some of 'a1 * 'a2 | None;;

let rec platree ( tree , lista ) = 
	match tree with
		Node( Some( k , w ) , l , r ) -> LNode(Some( k , w ) , [platree(l) , platree(r)] )
		| Empty -> LEmpty;;

platree( tt, []);;

(* nast�pne drzewa, listy leniwe. *)