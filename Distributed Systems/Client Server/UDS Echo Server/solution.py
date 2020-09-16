#!/usr/bin/env python2

import socket
import threading


def process_client_connection(connection):
    while True:
        message = connection.recv(4096)
        connection.send(message)

        if message == "END":
            break


if __name__ == '__main__':
    sock = socket.socket(socket.AF_UNIX)
    sock.bind("./socket")
    sock.listen(10)

    while True:
        connection = sock.accept()[0]
        threading.Thread(target=process_client_connection, args=(connection,)).start()
