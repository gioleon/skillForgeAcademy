package server

import "net/http"

func New(addr string) http.Server {
	return http.Server{Addr: ":" + addr}
}
