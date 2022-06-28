package Server;

import Parsers.*;
import Tree.tree;

import java.io.*;
import java.net.*;

class server
{
    public static void main(String[] args)
    {

        try (ServerSocket serverSocket = new ServerSocket(4444)) {

            System.out.println("Server is listening on port 4444");

            Socket socket = serverSocket.accept();

            InputStream input = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter out = new PrintWriter(output, true);

            String type = in.readLine();
            try
            {
                resolvingType(type, in, out);
            }
            catch (unknownCaseException e)
            {
                e.printStackTrace();
            }

            socket.close();

        }
        catch (IOException ex)
        {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void resolvingType(String type, BufferedReader in, PrintWriter out) throws unknownCaseException
    {
        switch(type)
        {
            case "i":
            {
                consoleInteraction<Integer> ci = new consoleInteraction<>(new tree<Integer>(), new parserInt(), in, out);
                ci.run();
            }
            case "d":
            {
                consoleInteraction<Double> ci = new consoleInteraction<>(new tree <Double>(), new parserDouble(), in, out);
                ci.run();
            }
            case "s":
            {
                consoleInteraction<String> ci = new consoleInteraction<>(new tree <String>(), new parserString(), in, out);
                ci.run();
            }
            default:
            {
                throw new unknownCaseException("Check data and try again");
            }
        }
    }

}