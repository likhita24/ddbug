// Copyright 2017 Istio Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package v1

import (
	"fmt"
	"istio.io/istio/pkg/log"
)

const (
	// Service accounts for Mixer and Pilot, these are hardcoded values at setup time
	mixerSvcAccName string = "istio-mixer-service-account"
	pilotSvcAccName string = "istio-pilot-service-account"
)

func getSAN(domain, ns, svcAccName string) []string {

	log.Infof("[调试标记 - pilot - pkg - proxy - envoy - v1 - infra_auth.go - getSAN()")

	// spiffe SAN for services is of the form. e.g. for pilot
	// "spiffe://cluster.local/ns/istio-system/sa/istio-pilot-service-account"
	svcSAN := fmt.Sprintf("spiffe://%v/ns/%v/sa/%v", domain, ns, svcAccName)
	svcSANs := []string{svcSAN}
	return svcSANs
}

// GetMixerSAN returns the SAN used for mixer mTLS
func GetMixerSAN(domain, ns string) []string {

	log.Infof("[调试标记 - pilot - pkg - proxy - envoy - v1 - infra_auth.go - GetMixerSAN()")

	return getSAN(domain, ns, mixerSvcAccName)
}

// GetPilotSAN returns the SAN used for pilot mTLS
func GetPilotSAN(domain, ns string) []string {

	log.Infof("[调试标记 - pilot - pkg - proxy - envoy - v1 - infra_auth.go - GetPilotSAN()")

	return getSAN(domain, ns, pilotSvcAccName)
}
