#*******************************************************************************
# Copyright (c) 2008, 2010 Obeo.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     Obeo - initial API and implementation
#*******************************************************************************
#!/bin/bash
PROMO_LOGS_DIR=$HOME/promo_logs
RELENG_DIR="/opt/users/hudsonbuild/.hudson/jobs/cbi-emf-eef-0.7-nightly/workspace/org.eclipse.emf/org.eclipse.emf.eef/releng"
ANT="/opt/public/common/apache-ant-1.7.1/bin/ant"
logFile=$HOME/cronLog.txt

rm -f $logFile
touch $logFile
echo "[`date +%Y/%m/%d\ %H:%M`]: publishing nightly build ..." >> $logFile
mkdir -p $PROMO_LOGS_DIR
$ANT -f $RELENG_DIR/promote.xml -Dpromote.properties=$RELENG_DIR/promote-N.properties 2>/dev/null 1> $PROMO_LOGS_DIR/cbi-emf-eef-promo-N.txt
