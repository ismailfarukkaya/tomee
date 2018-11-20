package org.superbiz.rest;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class BookResource {

    @Inject
    BookBean bookBean;

    @GET
    public String status() {
        return "ok";
    }

    @POST
    @Path("/books")
    public void addBook(Book newBook) {
        bookBean.addBook(newBook);
    }

    @DELETE
    @Path("/books/{id}")
    public void deleteBook(@PathParam("id") int id) {
        bookBean.deleteBook(id);
    }

    @PUT
    @Path("/books")
    public void updateBook(Book updatedBook) {
        bookBean.updateBook(updatedBook);
    }

    @GET
    @Path("/books/{id}")
    public Book getBook(@PathParam("id") int id) {
        return bookBean.getBook(id);
    }

    @GET
    @Path("/books")
    public List<Book> getListOfBooks() {
        return bookBean.getBooks();
    }

}
