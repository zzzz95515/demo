package ru.mpei.prob.model;

import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;

import java.util.Collection;

public interface CloningFactory {
    Collection<IdentifiedObject> clone(Collection<IdentifiedObject> initialObjects, Integer synthesizedNumber);
}
