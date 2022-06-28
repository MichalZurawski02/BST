package Server;

import Parsers.parser;
import Tree.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class consoleInteraction <T extends Comparable<T>>
{
    private final tree<T> clientTree;
    private final Parsers.parser parser;
    private final BufferedReader in;
    private final PrintWriter out;

    public consoleInteraction(tree<T> clientTree, parser parser, BufferedReader in, PrintWriter out)
    {

        this.clientTree = clientTree;
        this.parser = parser;
        this.in = in;
        this.out = out;
    }

    public void run()
    {
        //noinspection InfiniteLoopStatement
        while(true)
        {
            try
            {
                String line = "";
                while (!line.equals("exit"))
                {
                    line = in.readLine();
                    switch (line) {
                        case "insert" -> {
                            line = in.readLine();
                            T value = (T) parser.parse(line);
                            clientTree.insert(value);
                            out.println("Insertion done: " + line);
                        }
                        case "delete" -> {
                            line = in.readLine();
                            T value = (T) parser.parse(line);
                            clientTree.delete(value);
                            out.println("Deleting done: " + line);
                        }
                        case "search" -> {
                            line = in.readLine();
                            T value = (T) parser.parse(line);
                            out.println("Searching done, result: " + clientTree.search(value));
                        }
                        case "draw" -> clientTree.drawInOrder(out);

                        default -> out.println("Nieznana operacja");
                    }
                }
            }
            catch(final NumberFormatException e)
            {
                out.println("Wrong data, try again.");
                e.printStackTrace();
            }
            catch(final IOException e)
            {
                System.out.println("Server exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


}