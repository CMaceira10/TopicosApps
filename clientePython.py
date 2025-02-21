#CLIENTE PYTHON

import socket

HOST = 'localhost'      #El host remoto
PORT = 5000
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    s.sendall(b'Hola Mundo. Soy cliente Python')
    data = s.recv(1024)
print('Recibido ', repr(data))
