package com.asso.mapper;

import com.asso.dao.MemberDao;
import com.asso.model.Cotisation;
import com.asso.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class CotisationMapper {
    @Autowired
    static MemberDao memberDao;
    public static Cotisation toCotisationMapper(CotisationData data, Member member) {
        return new Cotisation(
                data.getId(), data.getMonth(), data.getAmount(),
                data.getDate(), data.getMeanOfPayment(),
                data.getDescription(), member);
    }

    public static CotisationData toCotisationDataMapper(Cotisation data) {
        return new CotisationData(
                data.getId(), data.getMonth(), data.getAmount(),
                data.getDate(), data.getMeanOfPayment(),
                data.getDescription(), data.getMember().getId());
    }
}
