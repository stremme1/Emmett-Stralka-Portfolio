#lang racket

(provide make-BST make-empty-BST make-BST-leaf key leftTree rightTree emptyTree? leaf?)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; BST data structure - DO NOT MODIFY!!!
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Construct a BST
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; make-BST: constructs a BST
;;   inputs: a key, the left subtree, and the right subtree
;;   output: a new BST, with key as the root and with left and right subtrees
(define (make-BST key left right)
  (list key left right))


;; make-empty-BST: creates an empty BST
;;   output: an empty tree
(define (make-empty-BST)
  '())


;; make-BST-leaf: creates a BST with one node (aka a leaf)
;;   input: a key
;;   output: a new BST with key as the root
(define (make-BST-leaf key)
  (make-BST key                ; key
            (make-empty-BST)   ; left subtree
            (make-empty-BST))) ; right subtree


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Access elements of a BST
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; key: returns the key at the root node of a non-empty BST
;;   input: a non-empty BST
;;   output: the key at the root node
(define (key tree)
  (first tree))


;; leftTree: returns the left tree of a non-empty BST
;;   input: a non-empty BST
;;   output: the left subtree
(define (leftTree tree)
  (second tree))


;; rightTree: returns the right tree of a non-empty BST
;;   input: a non-empty BST
;;   output: the right subtree
(define (rightTree tree)
  (third tree))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Query the structure of a BST
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; emptyTree?: checks if a BST is empty
;;   input: a BST
;;   outputs: true if tree is empty, otherwise false
(define (emptyTree? tree)
  (empty? tree))


;; leaf?: checks if a non-empty BST is a leaf
;;   input: a non-empty BST
;;   output: true if tree is a leaf, otherwise false
(define (leaf? tree)
  (and (empty? (leftTree tree))
       (empty? (rightTree tree))))