/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hop.pipeline.transforms.mergejoin;

import org.apache.hop.core.injection.BaseMetadataInjectionTest;
import org.apache.hop.junit.rules.RestoreHopEngineEnvironment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeJoinMetaInjectionTransform extends BaseMetadataInjectionTest<MergeJoinMeta> {
  @ClassRule public static RestoreHopEngineEnvironment env = new RestoreHopEngineEnvironment();

  @Before
  public void setup() throws Exception {
    MergeJoinMeta m = new MergeJoinMeta();
    m.setKeyFields1(Arrays.asList("id1"));
    m.setKeyFields2(Arrays.asList("id2"));
    setup(m);
  }

  @Test
  public void test() throws Exception {
    check("JOIN_TYPE", () -> meta.getJoinType());
    check("LEFT_TRANSFORM", () -> meta.getLeftTransformName());
    check("RIGHT_TRANSFORM", () -> meta.getRightTransformName());
    check("KEY_FIELD1", () -> meta.getKeyFields1().get(0));
    check("KEY_FIELD2", () -> meta.getKeyFields2().get(0));
  }
}
