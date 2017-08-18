/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.projecttype.wizard;

import com.google.gwt.resources.client.ClientBundle;
import org.eclipse.che.ide.projecttype.wizard.categoriespage.CategoriesPageViewImpl;

/** @author Ann Shumilova */
public interface ProjectWizardResources extends ClientBundle {

  @Source({"categoriespage/MainPage.css", "org/eclipse/che/ide/api/ui/style.css"})
  CategoriesPageViewImpl.Style mainPageStyle();
}
