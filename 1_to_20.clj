
;http://www.4clojure.com/problem/1
;This is really straight foward, basically to understand the syntax
;so between the parentheses you have (function_name param_list),
;eg: (= 1 1) means 1 == 1, so it will return true.
; (= true) returns true as well, just like if (true)

(__ (= true))
true


;http://www.4clojure.com/problem/2
;Moving ahead with, doing some math:
;(* 2 3) returns 6
;(- 10 6) returns 4
;and then it lasts (= 4 4) and test goes green =p
(= (- 10 (* 2 3)) __)
4


;http://www.4clojure.com/problem/3
;As clojure runs on JVM, you can call some methods from Java String
;in this case it's calling method .toUpperCase to the string "hello world"
(= __ (.toUpperCase "hello world"))
"HELLO WORLD"


;http://www.4clojure.com/problem/4
;the command list uses the following arguments to construct a list
;but also you can declare whatever after a ' and the languague will try to convert later
;In this case you are declaring a list of static arguments, so it will be converted into a list when needed
;Advanced tip: if you need a list with dynamic values like (1 2 (+ 1 2)) you better go for (list )
(= (list __) '(:a :b :c))
:a :b :c


;http://www.4clojure.com/problem/5
;Explanation of conj, in this case it will insert in the head of the list.
;But this behaviour depends of your data structure, in Clojure list is a linked list so the cheapest
;way to add something, is in the head. But a vector, hashmap, set things can go different
(= __ (conj '(2 3 4) 1))
(= __ (conj '(3 4) 2 1))
(list 1 2 3 4)


;http://www.4clojure.com/problem/6
;The equal = can take more than two params, acctually a list of it, it's just showing
;that a list and a vector are compatible when it comes to equalty
(= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
:a :b :c


;http://www.4clojure.com/problem/7
;This shows conj against a vector, which behaves as a array, so the cheapest way is to increase the size and add it in the end.
(= __ (conj [1 2 3] 4))
(= __ (conj [1 2] 3 4))
[1 2 3 4]


;http://www.4clojure.com/problem/8
;on the first statement it's showing that a set of values are always unique.
;eg (set '(1 1)) is the same as (set '(1))
;the second statement it shows a union function, it's not the standard way of doing. 
;You can see the whole package namespace but its not that hard
(= __ (set '(:a :a :b :c :c :c :c :d :d)))
(= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
(set '(:a :b :c :d))


;http://www.4clojure.com/problem/9
;a set doesnt matter the order. ah also the syntax #{} is used to declare a new set.
(= #{1 2 3 4} (conj #{1 4 3} __))
2

;http://www.4clojure.com/problem/10
;hash-map is the implementation of dictionary based on key-value standard.
;there are two ways of declaring it, the first one is using the function hash-map then a list
;  which (hash-map :key1 :value1, :key2 :value2) . The comma is totally useless, the compiler ignores it.
;The other way to create it is: {:key1 :value1 :key2 :value2 } and it goes
;when you call (:key1 {:key1 :value1 :key2 :value2 }) it will return the :value1
(= __ ((hash-map :a 10, :b 20, :c 30) :b))
(= __ (:b {:a 10, :b 20, :c 30}))
20


;http://www.4clojure.com/problem/11
;Demonstrating that you can use conj on maps as well.
(= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
{:b 2}


;http://www.4clojure.com/problem/12
;Three methods to get values from a list, first, second and last. They work both for '() (list) and vectors
(= __ (first '(3 2 1)))
(= __ (second [2 3 4]))
(= __ (last (list 1 2 3)))
3


;http://www.4clojure.com/problem/13
;rest return a new list skiping the first element of the original one.
;you can type on a clojure console (doc rest) for more information.
(= __ (rest [10 20 30 40]))
'(20 30 40)


;http://www.4clojure.com/problem/14
;yay! introducing functions!!! 
;they are all ways to declare functions, let's start:
; (fn name [] ()) this is one of easies to understand
;   basically fn is the function that declares a new function, followed by a name which is optional,
;   Then you have a vector of arguments (can be empty) and then the "body" of oyur function like (fn add_one [n] (+ 1 n))
;
;The fn also can be annonymus, eg: (fn [x] (+ 1 x))
;
; When the function should be very simple, you can declare as #() lets understand.
;  eg: #(+ 1 %) per se it's just a declaration if you run (#(+ 1 %) 2) the result should be 3,
;  #() says its a function, % is the coming parameter.
;
;partial returns another function. eg: (partial + 1) it returns a new function that executes the method + in 1 and all others parameters you pass
;so its also a declaration of a function, to it actually work ((partial + 1) 2) returns 3.
(= __ ((fn add-five [x] (+ x 5)) 3))
(= __ ((fn [x] (+ x 5)) 3))
(= __ (#(+ % 5) 3))
(= __ ((partial + 5) 3))
8


;http://www.4clojure.com/problem/15
;This is a good exercise to write few functions, there are 
(= (__ 2) 4)
(= (__ 3) 6)
(= (__ 11) 22)
(= (__ 7) 14)

; As there are many ways to declare a function, you can pick:
(fn twice [n] (* 2 n)) 
(fn [x] (* 2 x))
#(* 2 %)
(partial * 2)

;http://www.4clojure.com/problem/16
;Here is a function to format the string, concat "Hello, " the parameter and "!"
;There are plenty ways of doing so, the simplest one I find is to create a new string passing substrings in order
;you can test (doc str) on console to understand better.
(= (__ "Dave") "Hello, Dave!")
(= (__ "Jenn") "Hello, Jenn!")
(= (__ "Rhea") "Hello, Rhea!")
#(str ["Hello, " % "!"])


;http://www.4clojure.com/problem/17
;Warning, this map is very different from the hash-map!
;hash-mep is a dictionary and this one is a function that applies another function into a list and returns a new list of results.
;in other words (map #(+ 1 %) (list 1 2 3))  it will execute the function #(+ 1 %) to each element of the following list 
;and returns a new list containing '(2 3 4)
; TIP: this function is really usefull, spend sometime in https://clojuredocs.org/clojure.core/map totally worth it!
(= __ (map #(+ % 5) '(1 2 3)))
'(6 7 8)


;http://www.4clojure.com/problem/18
;Filter, as the name says it will select a fraction of the original list based on a true/false function that will be applied to each element.
;eg: (filter #(= 2) '(1 2 3 4)) will return '(2)
;Tip: look at https://clojuredocs.org/clojure.core/filter
(= __ (filter #(> % 5) '(3 4 5 6 7)))
'(6 7)


;http://www.4clojure.com/problem/19
;This is a bit easier, how to get the last element without using the last function.
;only simple solution is to reverse the list and get the first element, 
;https://clojuredocs.org/clojure.core/reverse
(= (__ [1 2 3 4 5]) 5)
(= (__ '(5 4 3)) 3)
(= (__ ["b" "c" "d"]) "d")
(fn [x] (first (reverse x)))


;http://www.4clojure.com/problem/20
;Return the second to last element,
;the same logic of #19, but this time I decided to do something better using comp.
;comp is a macro with creates a composition of functions, so instead of declaring a function that reverses x and get the second element
;we can compose a new function based on those two. (comp second reverse) this retruns a new function that when called will execute reverse then second on this order.
;https://clojuredocs.org/clojure.core/comp
(= (__ (list 1 2 3 4 5)) 4)
(= (__ ["a" "b" "c"]) "b")
(= (__ [[1 2] [3 4]]) [1 2])
(comp second reverse)

