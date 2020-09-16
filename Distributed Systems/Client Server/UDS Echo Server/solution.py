#!/usr/bin/python2
import sys


def process_client_connection(connection):
    while True:
        message = connection.recv(1024)
        sys.stdout.flush()

        if message == "END":
            break

        connection.send(message)
