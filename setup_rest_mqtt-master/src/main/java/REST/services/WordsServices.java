package REST.services;

import REST.beans.User;
import REST.beans.Users;
import REST.beans.Word;
import REST.beans.Words;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("words") // defines URI where res of this class are located
public class WordsServices {

    // add a word (name, definition)
    @Path("add")
    @POST
    @Consumes({"application/json", "application/xml"})
    public Response addWord(Word word){
        Word w =Words.getInstance().getByName(word.getName());
        if(w == null){
            Words.getInstance().add(word);
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    // get a word definition by its name
    @Path("get/{name}")
    @GET
    @Produces({"application/json", "application/xml"})
    public Response getByWordName(@PathParam("name") String name){
        Word w = Words.getInstance().getByName(name);
        if(w!=null)
            return Response.ok(w).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    // Modify a word definition by its name
    @Path("modify")
    @PUT
    @Produces({"application/json", "application/xml"})
    public Response modify(Word word){
        Word w = Words.getInstance().getByName(word.getName());
        if(w!=null){
            Words.getInstance().modify(word);
            return Response.ok("true").build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
