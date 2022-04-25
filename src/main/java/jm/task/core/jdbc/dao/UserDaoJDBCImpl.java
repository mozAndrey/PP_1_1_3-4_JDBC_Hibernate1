package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("create table  if not exists userstest (" +
                    "id SMALLINT not null auto_increment," +
                    "name VARCHAR(30) not null," +
                    "lastName varchar(30) not null," +
                    "age SMALLINT not null," +
                    "primary key ( id ) )");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void dropUsersTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("drop table if exists userstest");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Util.getConnection();
            preparedStatement = connection.prepareStatement("insert into userstest " +
                    "(name, lastName, age) values " +
                    "(?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException c) {
            c.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void removeUserById(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Util.getConnection();
            preparedStatement = connection.prepareStatement("delete  from userstest where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception ignored) {
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select  * from userstest");
            while (resultSet.next()) {
                list.add(new User(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ignored) {
            }
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception ignored) {
            }
        }
        return list;
    }

    public void cleanUsersTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("truncate table userstest");
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception ignored) {
            }
        }
    }
}
