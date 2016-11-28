/*
 * Copyright 2016 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.operation.impl.get;

import uk.gov.gchq.gaffer.commonutil.iterable.CloseableIterable;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.GetIterableElementsOperation;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;

/**
 * Restricts {@link uk.gov.gchq.gaffer.operation.impl.get.GetElements} to only return {@link uk.gov.gchq.gaffer.data.element.Edge}s.
 * See implementations of {@link GetEdges} for further details.
 *
 * @param <SEED_TYPE> the seed seed type
 * @see uk.gov.gchq.gaffer.operation.impl.get.GetElements
 */
public class GetEdges extends GetElements<EdgeSeed, Edge> {
    public GetEdges() {
        super();
        setIncludeEdges(IncludeEdgeType.ALL);
    }

    public GetEdges(final Iterable<EdgeSeed> seeds) {
        super(seeds);
        setIncludeEdges(IncludeEdgeType.ALL);
    }

    public GetEdges(final CloseableIterable<EdgeSeed> seeds) {
        super(seeds);
        setIncludeEdges(IncludeEdgeType.ALL);
    }

    public GetEdges(final View view) {
        super(view);
        setIncludeEdges(IncludeEdgeType.ALL);
    }

    public GetEdges(final View view, final Iterable<EdgeSeed> seeds) {
        super(view, seeds);
        setIncludeEdges(IncludeEdgeType.ALL);
    }

    public GetEdges(final View view, final CloseableIterable<EdgeSeed> seeds) {
        super(view, seeds);
        setIncludeEdges(IncludeEdgeType.ALL);
    }

    public GetEdges(final GetIterableElementsOperation<EdgeSeed, ?> operation) {
        super(operation);
    }

    @Override
    public boolean isIncludeEntities() {
        return false;
    }

    @Override
    public void setIncludeEntities(final boolean includeEntities) {
        if (includeEntities) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " does not support including entities");
        }
    }

    @Override
    public void setIncludeEdges(final IncludeEdgeType includeEdges) {
        if (IncludeEdgeType.NONE == includeEdges) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " requires edges to be included");
        }

        super.setIncludeEdges(includeEdges);
    }

    public abstract static class BaseBuilder<CHILD_CLASS extends BaseBuilder<?>>
            extends GetElements.BaseBuilder<GetEdges, EdgeSeed, Edge, CHILD_CLASS> {
        public BaseBuilder() {
            super(new GetEdges());
        }
    }

//    public static final class Builder<OP_TYPE extends GetEdges>
//            extends BaseBuilder<OP_TYPE, Builder<OP_TYPE>> {
//
//        protected Builder(final OP_TYPE op) {
//            super(op);
//        }
//
//        public Builder() {
//            super((OP_TYPE) new GetEdges());
//        }
//
//        @Override
//        protected Builder<OP_TYPE> self() {
//            return this;
//        }
//    }

    public static final class Builder extends BaseBuilder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }
    }
}
