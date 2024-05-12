// Interface for database operations
interface Database {
    void prepare() throws Exception;
    void commit() throws Exception;
    void rollback() throws Exception;
}