package com.akash.cassandra.dao;

import com.akash.cassandra.entity.User;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    @Autowired
    private CassandraOperations cassandraTemplate;

    @Autowired
    private Session session;

    @Override
    public void insert(User user) {
        cassandraTemplate.insert(user);
    }


    //select * from user where first_name=?1 and last_name=?2 and adhar_number=?3
    @Override
    public List<User> findAllByFirstNameAndLastNameAndAdharNumber(String firstName, String lastName, String adharNumber) {
        return cassandraTemplate.select(Query.query(Criteria.where("firstName").is(firstName))
                .and(Criteria.where("lastName").is(lastName))
                .and(Criteria.where("adharNumber").is(adharNumber)), User.class);
    }

    /*@Override
    public List<UserViewed> findGroupedQuestionByMerchantAndUser(String contractId, String userId) {
        String query = "Select question_id,count(*) as count from user_viewed " +
                " where contract_id = '"+contractId+"' and user_id = '"+userId+"' group by question_id";
        ResultSet rs = session.execute(query);
        List<UserViewed> userVieweds = new ArrayList<UserViewed>();
        for (Row row : rs) {
            UserViewed data = new UserViewed(row.getLong("question_id"), row.getLong("count"));
            userVieweds.add(data);
        }
        return userVieweds;
    }

    cassandraTemplate.update(
            Query.query(Criteria.where("contractId").is(contractId)),
            Update.empty().increment("count"), UserViewed.class);*/
}
