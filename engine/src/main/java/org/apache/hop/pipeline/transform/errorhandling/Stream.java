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

package org.apache.hop.pipeline.transform.errorhandling;

import org.apache.hop.core.Const;
import org.apache.hop.pipeline.transform.TransformMeta;

public class Stream implements IStream {

  private String description;
  private StreamType streamType;
  private TransformMeta transformMeta;
  private StreamIcon streamIcon;
  private String subject;

  /**
   * @param streamType
   * @param transformMeta
   * @param description
   * @param streamIcon
   * @param subject
   */
  public Stream(
      StreamType streamType,
      TransformMeta transformMeta,
      String description,
      StreamIcon streamIcon,
      String subject) {
    this.streamType = streamType;
    this.transformMeta = transformMeta;
    this.description = description;
    this.streamIcon = streamIcon;
    this.subject = subject;
  }

  public Stream(IStream stream) {
    this(
        stream.getStreamType(),
        stream.getTransformMeta(),
        stream.getDescription(),
        stream.getStreamIcon(),
        stream.getSubject());
  }

  public String toString() {
    if (transformMeta == null) {
      return "Stream type " + streamType + Const.CR + description;
    } else {
      return "Stream type "
          + streamType
          + " for transform '"
          + transformMeta.getName()
          + "'"
          + Const.CR
          + description;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof IStream)) {
      return false;
    }
    if (obj == this) {
      return true;
    }

    IStream stream = (IStream) obj;

    if (description.equals(stream.getDescription())) {
      return true;
    }

    return false;
  }

  @Override
  public int hashCode() {
    return description.hashCode();
  }

  @Override
  public String getTransformName() {
    if (transformMeta == null) {
      return null;
    }
    return transformMeta.getName();
  }

  /** @return the description */
  @Override
  public String getDescription() {
    return description;
  }

  /** @param description the description to set */
  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  /** @return the streamType */
  @Override
  public StreamType getStreamType() {
    return streamType;
  }

  /** @param streamType the streamType to set */
  @Override
  public void setStreamType(StreamType streamType) {
    this.streamType = streamType;
  }

  /** @return the transformMeta */
  @Override
  public TransformMeta getTransformMeta() {
    return transformMeta;
  }

  /** @param transformMeta the transformMeta to set */
  @Override
  public void setTransformMeta(TransformMeta transformMeta) {
    this.transformMeta = transformMeta;
  }

  /** @return the streamIcon */
  @Override
  public StreamIcon getStreamIcon() {
    return streamIcon;
  }

  /** @param streamIcon the streamIcon to set */
  @Override
  public void setStreamIcon(StreamIcon streamIcon) {
    this.streamIcon = streamIcon;
  }

  /** @return the subject */
  @Override
  public String getSubject() {
    return subject;
  }

  /** @param subject the subject to set */
  @Override
  public void setSubject(String subject) {
    this.subject = subject;
  }
}
