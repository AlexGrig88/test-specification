package com.example.testspecification.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.testspecification.model.DocumentState.*;

public enum Stage {
    OK(GOOD, SWEET, DEFAULT),
    NOTOK(BAD, LOH),
    MID(SLAVE);

    private List<DocumentState> states;
    Stage(DocumentState... stateArr) {
        states = new ArrayList<>(Arrays.asList(stateArr));
    }

    public List<DocumentState> getStates() {
        return states;
    }

    public static Stage fromState(DocumentState state) {
        var statesOk = Stage.OK.getStates();
        if (statesOk.contains(state))
            return Stage.OK;
        var statesNOTOK = Stage.NOTOK.getStates();
        if (statesNOTOK.contains(state))
            return Stage.NOTOK;
        var statesMid = Stage.MID.getStates();
        if (statesMid.contains(state))
            return Stage.MID;
        return null;
    }
}
