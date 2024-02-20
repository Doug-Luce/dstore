
# DStore

## Overview
DStore is a scalable data storage solution, drawing inspiration from Redis, renowned for its simplicity and performance. This project is for helping me learn Scala.

### Supported Commands
- **`Ping` Command**: Responds with `PONG`, a simple yet effective way to check the connectivity and responsiveness of the DStore server.
- **`Echo` Command**: Returns the same string that is sent to it, demonstrating basic interaction and response capabilities.

## How to Build
DStore is structured into two main components: the CLI (Command Line Interface) and the Server. These are managed as separate projects within an SBT (Scala Build Tool) build environment.

### Prerequisites
- Scala (version 2.13.12 or newer)
- SBT (Scala Build Tool)

### Building the Projects
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/Doug-Luce/dstore
   cd dstore
   ```

2. **Compile the Projects**:
   Navigate to the root directory of the project and run the following command to compile both the CLI and Server projects:
   ```sh
   sbt compile
   ```

3. **Running the Server**:
   To start the DStore server, execute the following command:
   ```sh
   sbt "project server" run
   ```
   This will start the server component of DStore, listening for incoming connections and commands.

4. **Running the CLI**:
   In a separate terminal, you can start the CLI component to interact with the server. Use the following command:
   ```sh
   sbt "project cli" run
   ```

   Once the CLI is running, you can issue commands to the server. For example:
   - To use the `ping` command, type `ping` and press Enter. The server should respond with `PONG`.
   - To use the `echo` command, type `echo <your message>` and press Enter. The server will echo back the message you sent.
5. **Exiting the server**: To exit the server use the `exit` command at the `Server>` prompt
```sh
   Server> exit
```


## Contributing
Contributions to DStore are welcome! If you have ideas for new features, improvements, or bug fixes, feel free to submit pull requests or open issues.

## License
MIT License

Copyright © 2024 Douglas Luce

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


---

