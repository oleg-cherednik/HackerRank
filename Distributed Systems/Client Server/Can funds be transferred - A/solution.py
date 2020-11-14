#!/usr/bin/env python3

import functools
import itertools

## Use this function to write data to socket
## write_string_to_socket(connection, message) where connection is the socket object and message is string

## Use this function to read data from socket
## def read_string_from_socket(connection) where connection is the socket object

## All global declarations go here
parents = None
parent_probs = None

## This function is called only once before any client connection is accepted by the server.
## Read any global datasets or configurations here
def init_server():

    print("Reading training set")
    sys.stdout.flush()


## This function is called everytime a new connection is accepted by the server.
## Service the client here
def process_client_connection(connection):

    while True:
        # read message
        message = read_string_from_socket(connection)

        print ("Message received = ", message)

        # if message != "END":
        #     fields = message.split(",")
            # a, b = map(int, fields[:2])
            # q1 = float(fields[2])
            # q = pow(10, q1)

            # message = "YES"
                # if compute_distance(a, b) > q else "NO"

        message = "YES"


        # write message
        write_string_to_socket(connection, message)

        if message == "END":
            break
