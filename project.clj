(defproject HelloPhoneGap "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :cljsbuild {
    ; The path to the top-level ClojureScript source directory:
    :source-path "src/cljs"
    ; The standard ClojureScript compiler options:
    ; (See the ClojureScript compiler documentation for details.)
    :compiler {
      :output-to "assets/www/main.js"  ; default: main.js in current directory
      :optimizations :whitespace
      :pretty-print true}})